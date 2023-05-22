package com.payu.assessment.payuAssessment.items;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.payu.assessment.payuAssessment.enums.BookTypes;

import lombok.Data;
import lombok.experimental.Accessors;



@Accessors(chain = true)
@Data
public class BookItem
{
	
	
    private String isbnNumber;
    
   private String name;

  
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private Date publishDate;
   
  private Double price;
   
   private BookTypes book_type;


}
