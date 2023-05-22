package com.payu.assessment.payuAssessment.response;

import java.util.List;

import com.payu.assessment.payuAssessment.items.BookItem;
import com.payu.assessment.payuAssessment.model.Book;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class GetAllBooksResponse extends GenericResponse
{

 	private List<Book> books;

}
