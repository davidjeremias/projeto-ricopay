package com.u2d.projeto.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeInstallmentsEnum {
	
	PARCELAMENTO_JUROS_ADM_CARTAO(3, "parcelamento com juros da administradora do cartão"),
	PARCELAMENTO_SEM_JUROS_LOJA(4, "parcelamento realizado pela loja e sem juros");
	
	private Integer id;
	private String nome;
	
	public static TypeInstallmentsEnum getEnumByid(Integer id) {
		for (TypeInstallmentsEnum chave : TypeInstallmentsEnum.values()) {
			if (chave.getId().equals(id)) {
				return chave;
			}
		}
		return null;
	}
	
}
