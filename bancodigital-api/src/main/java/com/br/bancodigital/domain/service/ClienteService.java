package com.br.bancodigital.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.bancodigital.domain.exception.ClienteNaoEncontradoException;
import com.br.bancodigital.domain.exception.NegocioException;
import com.br.bancodigital.domain.model.Cliente;
import com.br.bancodigital.domain.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		
		Optional<Cliente> clienteoExistente = clienteRepository.findBycpf(cliente.getCpf());
		
		if (clienteoExistente.isPresent() && !clienteoExistente.get().equals(cliente)) {
			throw new NegocioException(
					String.format("Já existe um cliente cadastrado com o cpf %s", cliente.getCpf()));
		}
		
		return clienteRepository.save(cliente);
	}
	
	
	public Cliente buscarPorId(Long clienteId) {
		return clienteRepository.findById(clienteId)
			.orElseThrow(() -> new ClienteNaoEncontradoException(clienteId));
	}

}
