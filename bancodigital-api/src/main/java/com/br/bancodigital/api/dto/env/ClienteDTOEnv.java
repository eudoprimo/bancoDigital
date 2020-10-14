package com.br.bancodigital.api.dto.env;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.br.bancodigital.domain.validation.Unico;
import com.br.bancodigital.domain.validation.ValidadorMaioridade;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteDTOEnv implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 747467147885015003L;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CPF
	@Unico
	private String cpf;

	@Email
	@Unico
	private String email;

	@NotBlank
	@ValidadorMaioridade
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private LocalDate dataDeNascimento;


}
