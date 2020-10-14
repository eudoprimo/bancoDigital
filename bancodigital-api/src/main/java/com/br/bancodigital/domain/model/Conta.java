package com.br.bancodigital.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Conta {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "cliente_id")
    private Long id;

    @Column(name = "AGENCIA",length = 4)
    private String agencia;

    @Column(name = "CONTA",length = 8)
    private String conta;

    @Column(name = "CODIGO_BANCO")
    private String CodigoBanco = "077";

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    
    
}


