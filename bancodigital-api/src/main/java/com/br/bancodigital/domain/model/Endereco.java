package com.br.bancodigital.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.br.bancodigital.domain.validation.ValidadorCep;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "ENDERECO")
public class Endereco {
	
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ValidadorCep
	@NotBlank
	@Column(name = "CEP")
	private String cep;

	@NotBlank
	@Column(name = "RUA")
    private String rua;

	@NotBlank
	@Column(name = "BAIRRO")
    private String bairro;

	@NotBlank
	@Column(name = "COMPLEMENTO")
    private String complemento;

	@NotBlank
	@Column(name = "CIDADE")
    private String cidade;

	@NotBlank
	@Column(name = "ESTADO")
    private String estado;

}
