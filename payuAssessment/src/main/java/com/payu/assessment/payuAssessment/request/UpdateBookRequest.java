package com.payu.assessment.payuAssessment.request;

import java.util.Date;


import com.payu.assessment.payuAssessment.enums.BookTypes;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UpdateBookRequest {
	
	
	
	  private String name;
	   
	  private String isbnNumber;
	   
	  private Date publishDate;
	
	  private Double price;
	 
	   private BookTypes book_type;

}
