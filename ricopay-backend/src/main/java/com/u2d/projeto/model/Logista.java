package com.u2d.projeto.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table(name = "TB009_LOGISTA")
public class Logista implements Serializable{
	
	private static final long serialVersionUID = -6341722907613547440L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_LOGISTA")
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "CO_CNPJ")
	private String cnpj;

	@Column(name = "NO_RAZAO_SOCIAL")
	private String nome;

	@Column(name = "NO_NOME_FANTASIA")
	private String fantasia;

	@Column(name = "DE_SITUACAO")
	private String situacao;

	@Column(name = "NO_NATUREZA_JURIDICA")
	private String naturezaJuridica;
	
	@Column(name = "DT_ABERTURA")
	private LocalDate dataAbertura;

	@Column(name = "NO_TIPO_EMPRESA")
	private String tipo;

	@Column(name = "DE_PORTE")
	private String porte;

	@Column(name = "DE_STATUS")
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ENDERECO_CO")
	private Endereco endereco;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTATO_CO")
	private Contato contato;
}
