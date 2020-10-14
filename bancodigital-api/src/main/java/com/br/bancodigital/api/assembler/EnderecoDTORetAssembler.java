package com.br.bancodigital.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.bancodigital.api.dto.ret.EnderecoDTORet;
import com.br.bancodigital.domain.model.Endereco;

@Component
public class EnderecoDTORetAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EnderecoDTORet toModel(Endereco endereco) {
		return modelMapper.map(endereco, EnderecoDTORet.class);
	}
	
	public List<EnderecoDTORet> toCollectionModel(List<Endereco> enderecos) {
		return enderecos.stream()
				.map(endereco -> toModel(endereco))
				.collect(Collectors.toList());
	}

}
