package com.br.bancodigital.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.br.bancodigital.api.assembler.DocumentoDTORetAssembler;
import com.br.bancodigital.api.dto.env.DocumentoDTOEnv;
import com.br.bancodigital.api.dto.ret.DocumentoDTORet;
import com.br.bancodigital.domain.model.Cliente;
import com.br.bancodigital.domain.model.DocumentoCliente;
import com.br.bancodigital.domain.repository.ClienteRepository;
import com.br.bancodigital.domain.service.ClienteService;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/clientes/{clienteId}/foto")
public class DocumentoController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;

	
	@Autowired
	private DocumentoDTORetAssembler documentoDTORetAssembler;
	
	@PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public DocumentoDTORet atualizarFoto(@PathVariable Long clienteId,
			 @Valid DocumentoDTOEnv documentoDTOEnv) {
		Cliente cliente = clienteService.buscarPorId(clienteId);
		
		MultipartFile arquivo = documentoDTOEnv.getArquivo();
		
		DocumentoCliente foto = new DocumentoCliente();
		foto.setCliente(cliente);
		foto.setDescricao(documentoDTOEnv.getDescricao());
		foto.setContentType(arquivo.getContentType());
		foto.setTamanho(arquivo.getSize());
		foto.setNomeArquivo(arquivo.getOriginalFilename());
		
		DocumentoCliente fotoSalva = clienteRepository.save(foto);
		
		return documentoDTORetAssembler.toModel(fotoSalva);
	}

}
