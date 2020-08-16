package com.u2d.projeto.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB011_PAGAMENTO")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "CO_PAGAMENTO")
	private Long id;
	
	@Column(name = "DE_STATUS")
	private String status;
	
	@Column(name = "NU_NIT")
	private String nit;
	
	@Column(name = "CO_ORDEM")
	private String orderId;
	
	@Column(name = "CO_MERCHANTUSN")
	private Long merchantUsn;
	
	@Column(name = "VL_VALOR")
	private Integer amount;
	
	@Column(name = "CO_AUTORIZADORA")
	private String authorizerCode;
	
	@Column(name = "DT_PAGAMENTO")
	private LocalDateTime dataHoraPayment;
}
