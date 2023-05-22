package com.payu.assessment.payuAssessment.response;

import com.payu.assessment.payuAssessment.model.Book;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class BookResponse extends GenericResponse
{
   private Book book;
}
