package com.br.bancodigital.domain.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.br.bancodigital.domain.validation.Unico;
import com.br.bancodigital.domain.validation.ValidadorMaioridade;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "NOME")
	private String nome;

	@NotBlank
	@Column(name = "SOBRENOME")
	private String sobrenome;

	@Unico
	@CPF
	@Column(name = "CPF")
	private String cpf;

	@Unico
	@Email
	@Column(name = "EMAIL")
	private String email;

	@ValidadorMaioridade
	@NotBlank
	@Column(name = "DATA_NASCIMENTO")
	private LocalDate dataNascimento;

	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	private DocumentoCliente documentoCliente;

	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	private Conta conta;

}
