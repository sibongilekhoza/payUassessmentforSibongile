package com.payu.assessment.payuAssessment.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse {

	private String responseMessage;

	private String developerMessage;

	private String responseCode;

}