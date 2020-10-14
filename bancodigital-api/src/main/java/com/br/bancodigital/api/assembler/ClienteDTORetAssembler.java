package com.br.bancodigital.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.bancodigital.api.dto.ret.ClienteDTORet;
import com.br.bancodigital.domain.model.Cliente;

@Component
public class ClienteDTORetAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ClienteDTORet toModel(Cliente cliente) {
		return modelMapper.map(cliente, ClienteDTORet.class);
	}
	
	public List<ClienteDTORet> toCollectionModel(List<Cliente> clientes) {
		return clientes.stream()
				.map(cliente -> toModel(cliente))
				.collect(Collectors.toList());
	}

}
