package com.u2d.projeto.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class EnderecoDTO implements Serializable {

    private static final long serialVersionUID = 385965650525402545L;

    private Long id;

    @NotNull
    @Size(max=10)
    private String cep;

    @NotNull
    @Size(max=100)
    private String logradouro;

    @Size(max=100)
    private String complemento;

    @NotNull
    @Size(max=100)
    private String bairro;

    @NotNull
    @Size(max=100)
    private String localidade;

    @NotNull
    @Size(max=2)
    private String uf;

    @NotNull
    @Size(max=20)
    private String ibge;
}
