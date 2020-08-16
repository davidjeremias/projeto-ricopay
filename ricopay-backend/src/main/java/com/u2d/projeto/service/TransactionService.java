package com.u2d.projeto.service;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.u2d.projeto.dto.CardDTO;
import com.u2d.projeto.dto.TransactionDTO;
import com.u2d.projeto.exception.NegocioException;
import com.u2d.projeto.model.Payment;
import com.u2d.projeto.model.Transaction;
import com.u2d.projeto.model.enums.TypeInstallmentsEnum;
import com.u2d.projeto.repository.TransactionRepository;
import com.u2d.projeto.util.DateUtil;

@Service
public class TransactionService {
	
	private static final String MERCHANT_ID = "merchant_id";
	private static final String MERCHANT_KEY = "merchant_key";
	private static final String MERCHANT_USN = "merchant_usn";
	private static final String ORDER_ID = "order_id";
	private static final String INSTALLMENTS = "installments";
	private static final String INSTALLMENT_TYPE = "installment_type";
	private static final String AUTHORIZER_ID = "authorizer_id";
	private static final String AMOUNT = "amount";
	private static final String CARD = "card";
	private static final String ENDPOINT_TRANSACTION = "transactions";
	private static final String ENDPOINT_PAYMENT = "payments/";
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${app.urlSitef}")
	String url;
	
	@Value("${app.merchantId}")
	String merchantId;
	
	@Value("${app.merchantKey}")
	String merchantKey;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private TransactionRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(TransactionService.class);
	
	public TransactionDTO payment(TransactionDTO transactionDTO) {
		Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);
		transaction.setInstallmentId(TypeInstallmentsEnum.getEnumByid(transactionDTO.getInstallmentId()));
		transaction.setDataHoraTransaction(LocalDateTime.now(ZoneId.of(DateUtil.getZoneId())));
		Transaction transactionSave = repository.save(transaction);
		transactionSave.setOrderId(transactionSave.getMerchantUsn().toString());
		TransactionDTO transactionCurrent = createTransaction(transactionSave);
		TransactionDTO transactionFinish = effectuatePayment(transactionDTO.getCard(), transactionCurrent.getPayment().getNit());
		Payment payment = modelMapper.map(transactionFinish.getPayment(), Payment.class);
		transactionSave.setCode(transactionFinish.getCode());
		transactionSave.setMessage(transactionFinish.getMessage());
		transactionSave.setPayment(payment);
		return modelMapper.map(repository.save(transactionSave), TransactionDTO.class);
	}
	
	private TransactionDTO createTransaction(Transaction transaction) {
		HttpHeaders headers = getHeaders(merchantId, merchantKey);
		
		JSONObject body = new JSONObject();
		body.put(MERCHANT_USN, transaction.getMerchantUsn());
		body.put(ORDER_ID, transaction.getMerchantUsn());
		body.put(INSTALLMENTS, transaction.getInstallments().toString());
		body.put(INSTALLMENT_TYPE, transaction.getInstallmentId().getId().toString());
		body.put(AUTHORIZER_ID, transaction.getAuthorizerId().toString());
		body.put(AMOUNT, transaction.getAmount().toString());
		ResponseEntity<TransactionDTO> response = null;
		
		HttpEntity<String> entity = new HttpEntity<>(body.toString(), headers);

		try {
		    response = restTemplate.postForEntity(url+ENDPOINT_TRANSACTION, entity, TransactionDTO.class);
		    if(response.getBody() != null) {
		    	if(response.getBody().getCode() != 0) {
		    		throw new NegocioException("Transação não criada");
		    	}
		    }
		    logger.info("NIT: "+ response.getBody().getPayment().getNit());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		   return response.getBody();
	}
	
	private TransactionDTO effectuatePayment(CardDTO cardDTO, String nit) {
		HttpHeaders headers = getHeaders(merchantId, merchantKey);
			
		JSONObject card = new JSONObject();
		card.put("number", cardDTO.getNumber());
		card.put("expiry_date", cardDTO.getExpiryDate());
		card.put("security_code", cardDTO.getSecurityCode());
		
		JSONObject body = new JSONObject();
		body.put(CARD, card);
		ResponseEntity<TransactionDTO> response = null;
		
		HttpEntity<String> entity = new HttpEntity<>(body.toString(), headers);
		
		try {
		    response = restTemplate.postForEntity(url+ENDPOINT_PAYMENT+nit, entity, TransactionDTO.class);
		    if(response.getBody() != null) {
		    	if(response.getBody().getPayment().getAuthorizerCode().equals("0")) {
		    		throw new NegocioException("Transação não efetuada");
		    	}
		    }
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		   return response.getBody();
	}

	private HttpHeaders getHeaders(String merchantId, String merchantKey) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType((MediaType.APPLICATION_JSON));
		headers.set(MERCHANT_ID, merchantId);
		headers.set(MERCHANT_KEY, merchantKey);
		return headers;
	}
	
}
