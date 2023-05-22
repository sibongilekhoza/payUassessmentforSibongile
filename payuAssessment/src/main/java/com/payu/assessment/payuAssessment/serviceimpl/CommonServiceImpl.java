package com.payu.assessment.payuAssessment.serviceimpl;


import java.util.Locale;
import java.text.MessageFormat;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.payu.assessment.payuAssessment.enums.HttpStatusEnum;
import com.payu.assessment.payuAssessment.service.CommonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommonServiceImpl implements CommonService{

	@Autowired
	private Environment env;
	
	@Autowired
	private MessageSource messageSource;
	
	
	@Override

	public HttpStatus convertStringToHttpStatus(HttpStatusEnum enums) {
		
	HttpStatus valueOf = null;
	try {
		valueOf = HttpStatus.valueOf(Integer.parseInt(enums.getHttpStatus()));
		return valueOf;
	} catch (Exception e) {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}
	
	}



	@Override
	public String getUniqueId() {
		return RandomStringUtils.randomAlphanumeric(8).toLowerCase();
	}



	@Override
	public String getMessage(String key, Object... args) {
		Locale locale = LocaleContextHolder.getLocale();
		String respMessage = null;
		try {
			respMessage = messageSource.getMessage(key, args, locale);
		} catch (NoSuchMessageException e) {
			respMessage = new MessageFormat(env.getProperty(key)).format(args);
		}
		return respMessage;
	}



	@Override
	public void validateRequest(BindingResult bindingResult)  {
	
		log.info("Validating the errors");
		if (bindingResult.hasErrors()) {
			String message = "";
			for (FieldError error : bindingResult.getFieldErrors()) {
				message = error.getDefaultMessage();
		 		log.info("Error message: " + message);
				
			}
		}
		
	}

}
