package com.br.bancodigital.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.bancodigital.api.assembler.ClienteDTOEnvDisassembler;
import com.br.bancodigital.api.assembler.ClienteDTORetAssembler;
import com.br.bancodigital.api.dto.env.ClienteDTOEnv;
import com.br.bancodigital.api.dto.ret.ClienteDTORet;
import com.br.bancodigital.domain.exception.ClienteNaoEncontradoException;
import com.br.bancodigital.domain.exception.NegocioException;
import com.br.bancodigital.domain.model.Cliente;
import com.br.bancodigital.domain.repository.ClienteRepository;
import com.br.bancodigital.domain.service.ClienteService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteDTOEnvDisassembler clienteDTOEnvDisassembler;
	
	@Autowired
	private ClienteDTORetAssembler clienteDTORetAssembler;
	

	
	
	@GetMapping
	public Page<ClienteDTORet> listar(@PageableDefault(size = 10) Pageable pageable) {		
		
		Page<Cliente> clientesPage = clienteRepository.findAll(pageable);
		
		List<ClienteDTORet> clienteDTORet = clienteDTORetAssembler
				.toCollectionModel(clientesPage.getContent());
		
		Page<ClienteDTORet> clienteDTORetPage  = new PageImpl<>(clienteDTORet, pageable, 
				clientesPage.getTotalElements());
		
		return clienteDTORetPage;
	}
	
	
	@GetMapping("/{usuarioId}")
	public ClienteDTORet buscar(@PathVariable Long clienteId) {
		Cliente cliente = clienteService.buscarPorId(clienteId);
		
		return clienteDTORetAssembler.toModel(cliente);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDTORet adicionar(@RequestBody @Valid ClienteDTOEnv clienteDTOEnv) {
		try {
			Cliente cliente = clienteDTOEnvDisassembler.toDomainObject(clienteDTOEnv);
			
			cliente = clienteService.salvar(cliente);
			
			return clienteDTORetAssembler.toModel(cliente);
		} catch (ClienteNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}
	
	

}
