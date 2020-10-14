package com.br.bancodigital.api.dto.ret;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DocumentoDTORet {

	private String nomeArquivo;
	private String descricao;
	private String contentType;
	private Long tamanho;
}
