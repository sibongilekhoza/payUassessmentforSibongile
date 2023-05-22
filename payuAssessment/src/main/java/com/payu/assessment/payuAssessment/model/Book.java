package com.payu.assessment.payuAssessment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.payu.assessment.payuAssessment.enums.BookTypes;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;



@Entity
@Table(name="Book")
@Accessors(chain = true)
@Data
@Getter
@Setter
public class Book 
{
	private static final long serialVersionUID = 1L;
	@Id
    private String id;
    
   @Column(name ="Name")
  
   private String name;
   
   @Column(name ="ISBN Number")
  private String isbnNumber;
   
   @Column(name ="Publish date")
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private Date publishDate;
   
   @Column(name ="Price")
  private Double price;
   
   @Column(name ="Book Type")
   private BookTypes book_type;

	
	
}
