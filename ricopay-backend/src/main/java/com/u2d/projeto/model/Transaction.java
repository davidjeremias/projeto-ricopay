package com.u2d.projeto.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.u2d.projeto.model.enums.TypeInstallmentsEnum;

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
@Table(name = "TB012_TRANSACAO")
public class Transaction{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "CO_MERCHANTUSN")
	private Long merchantUsn;
	
	@Column(name="CO_ORDEM")
	private String orderId;
	
	@Column(name="NU_PARCELA")
	private Integer installments;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="TP_PARCELA")
	private TypeInstallmentsEnum installmentId;
	
	@Column(name="CO_AUTORIZADORA")
	private Integer authorizerId;
	
	@Column(name="VL_VALOR")
	private Integer amount;
	
	@Column(name="CO_TRANSACAO")
	private Integer code;
	
	@Column(name="DE_MENSAGEM")
	private String message;
	
	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "PAGAMENTO_CO")
	private Payment payment;
	
	@Column(name="DT_TRANSACAO")
	private LocalDateTime dataHoraTransaction;
}
