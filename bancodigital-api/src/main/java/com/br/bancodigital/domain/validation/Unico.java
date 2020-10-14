package com.br.bancodigital.domain.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;



@Qualifier
@Target({ PARAMETER, FIELD })
@Retention(RUNTIME)
@Documented
public @interface Unico {

	public int grupo() default 0;
}
