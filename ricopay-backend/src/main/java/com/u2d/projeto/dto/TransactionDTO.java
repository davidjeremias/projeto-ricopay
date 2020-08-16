package com.u2d.projeto.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO implements Serializable{

	private static final long serialVersionUID = -8319284640771940014L;
	private Long merchantUsn;
	private String merchantId;
	private String merchantKey;
	private String orderId;
	private Integer installments;
	private Integer installmentId;
	private Integer authorizerId;
	private Integer amount;
	private Integer code;
	private String message;
	private CardDTO card;
	private PaymentDTO payment;
	private LocalDateTime dataHoraTransaction;
}
