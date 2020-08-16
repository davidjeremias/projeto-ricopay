package com.u2d.projeto.dto;

import java.io.Serializable;

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
public class CardDTO implements Serializable {

	private static final long serialVersionUID = -3552022634953798550L;
	private String number;
	private String expiryDate;
	private String securityCode;
	
}
