package com.u2d.projeto.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@EqualsAndHashCode
@Builder
@JsonIgnoreProperties
public class EmpresaDTO implements Serializable {

    private static final long serialVersionUID = 7134015189984215102L;

    private Long id;

    @NotNull
    @Size(max=20)
    private String cnpj;

    @NotNull
    @Size(max=100)
    private String nome;

    @NotNull
    @Size(max=100)
    private String fantasia;

    @NotNull
    private String situacao;

    @Size(max=150)
    @JsonProperty("natureza_juridica")
    private String naturezaJuridica;

    private String abertura;

    private LocalDate dataAbertura;

    private String tipo;

    private String porte;

    private String status;
    
    private String cep;

    private EnderecoDTO enderecoDTO;

    private ContatoDTO contatoDTO;
}
