package com.u2d.projeto.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class PaymentDTO implements Serializable{
	
	private static final long serialVersionUID = -5911004683953462829L;
	private Long id;
	private String status;
	private String nit;
	@JsonProperty("order_id")
	private String orderId;
	@JsonProperty("merchant_usn")
	private Long merchantUsn;
	private Integer amount;
	private String authorizerCode;
	private LocalDateTime dataHoraPayment;

}
