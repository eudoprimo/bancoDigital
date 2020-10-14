package com.br.bancodigital.api.dto.env;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.http.MediaType;

import com.br.bancodigital.domain.validation.FileContentType;
import com.br.bancodigital.domain.validation.FileSize;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DocumentoDTOEnv {
	
	@NotNull
	@FileSize(max = "500KB")
	@FileContentType(allowed = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
	private MultipartFile arquivo;
	
	@NotBlank
	private String descricao;

}
