package com.payu.assessment.payuAssessment.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Data
@EqualsAndHashCode(callSuper = false)
public class MandatoryException extends Exception {

	private static final long serialVersionUID = 1L;

	private String responseCode;

	private String responseMessage;

	private String developerMessage;

	private HttpStatus statusCode;
}
