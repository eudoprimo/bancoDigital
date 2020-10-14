package com.br.bancodigital.domain.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CepValidator implements
ConstraintValidator<ValidadorCep, String> {
	
	@Override
	public void initialize(final ValidadorCep constraintAnnotation) {
	}

	@Override
	public boolean isValid(String ValidadorCep, final ConstraintValidatorContext context) {
		boolean result = false;
		if ( ValidadorCep == null || "".equals(ValidadorCep) ) {
			result = true;
		} else {
			Pattern pattern = Pattern.compile("^(([0-9]{2}\\.[0-9]{3}-[0-9]{3})|([0-9]{2}[0-9]{3}-[0-9]{3})|([0-9]{8}))$");  
			Matcher matcher = pattern.matcher(ValidadorCep);
			result = matcher.find();
		}
		return result;
	}

}
