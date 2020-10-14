package com.br.bancodigital.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.bancodigital.api.dto.ret.DocumentoDTORet;
import com.br.bancodigital.domain.model.DocumentoCliente;

@Component
public class DocumentoDTORetAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DocumentoDTORet toModel(DocumentoCliente foto) {
		return modelMapper.map(foto, DocumentoDTORet.class);
	}

}
