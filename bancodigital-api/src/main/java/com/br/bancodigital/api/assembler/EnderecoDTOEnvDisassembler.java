package com.br.bancodigital.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.bancodigital.api.dto.env.EnderecoDTOEnv;
import com.br.bancodigital.domain.model.Endereco;

@Component
public class EnderecoDTOEnvDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Endereco toDomainObject(EnderecoDTOEnv enderecoEnv) {
		return modelMapper.map(enderecoEnv, Endereco.class);
	}
	
	public void copyToDomainObject(EnderecoDTOEnv enderecoEnv, Endereco endereco) {
		modelMapper.map(enderecoEnv, endereco);
	}

}
