package com.br.bancodigital.api.dto.ret;

import java.io.Serializable;

import lombok.Data;

@Data
public class EnderecoDTORet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7161754424181372212L;

	private String cep;

    private String rua;

    private String bairro;

    private String complemento;

    private String cidade;

    private String estado;

}
