package com.br.bancodigital.api.dto.env;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.br.bancodigital.domain.validation.ValidadorCep;

public class EnderecoDTOEnv implements Serializable {

	private static final long serialVersionUID = -3207911220938587556L;

	@NotBlank
	@ValidadorCep
	private String cep;

	@NotBlank
	private String rua;

	@NotBlank
	private String bairro;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotBlank
	private String estado;

}
