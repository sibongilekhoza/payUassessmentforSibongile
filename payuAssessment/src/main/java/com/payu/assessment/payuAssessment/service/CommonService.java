package com.payu.assessment.payuAssessment.service;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import com.payu.assessment.payuAssessment.enums.HttpStatusEnum;

public interface CommonService 
{

	void validateRequest(BindingResult bindingResult) ;
	HttpStatus convertStringToHttpStatus(HttpStatusEnum enums);
	
	String getMessage(String key, Object... args);
	String getUniqueId();
	
	
}
