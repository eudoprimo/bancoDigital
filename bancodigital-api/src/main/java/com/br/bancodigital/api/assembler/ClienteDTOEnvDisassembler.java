package com.br.bancodigital.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.bancodigital.api.dto.env.ClienteDTOEnv;
import com.br.bancodigital.domain.model.Cliente;

@Component
public class ClienteDTOEnvDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Cliente toDomainObject(ClienteDTOEnv clienteEnv) {
		return modelMapper.map(clienteEnv, Cliente.class);
	}
	
	public void copyToDomainObject(ClienteDTOEnv clienteEnv, Cliente cliente) {
		modelMapper.map(clienteEnv, cliente);
	}

}
