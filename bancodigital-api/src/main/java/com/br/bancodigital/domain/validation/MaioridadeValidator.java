package com.br.bancodigital.domain.validation;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaioridadeValidator implements
ConstraintValidator<ValidadorMaioridade, Date> {
	
	@Override
	public void initialize(ValidadorMaioridade constraintAnnotation) {

	}

	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -18);

		Date data18AnosAtras = calendar.getTime();

		return value.before(data18AnosAtras);

	}

}
