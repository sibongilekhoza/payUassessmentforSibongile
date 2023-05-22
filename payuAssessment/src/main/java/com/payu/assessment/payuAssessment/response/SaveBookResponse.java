package com.payu.assessment.payuAssessment.response;

import com.payu.assessment.payuAssessment.items.BookItem;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Accessors(chain=true)
@Data
@EqualsAndHashCode(callSuper = true)
public class SaveBookResponse  extends GenericResponse{
	
	
	private BookItem book;

}
