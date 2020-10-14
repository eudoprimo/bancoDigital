package com.br.bancodigital.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.bancodigital.domain.model.DocumentoCliente;

@Repository
public interface DocumentoClienteRepository extends JpaRepository<DocumentoCliente, Long> {

}
