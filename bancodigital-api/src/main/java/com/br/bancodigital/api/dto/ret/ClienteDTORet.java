package com.br.bancodigital.api.dto.ret;

import java.io.Serializable;
import java.time.LocalDate;

import com.br.bancodigital.domain.model.Conta;
import com.br.bancodigital.domain.model.DocumentoCliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class ClienteDTORet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4521701789402536162L;

	private Long id;

    private String nome;

    private String sobrenome;

    private String cpf;

    private String email;

    private String cnh;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDate dataDeNascimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EnderecoDTORet endereco;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DocumentoCliente documentoCliente;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Conta conta;

}
