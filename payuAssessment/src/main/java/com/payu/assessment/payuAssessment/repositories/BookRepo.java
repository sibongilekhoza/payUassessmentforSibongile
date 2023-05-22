package com.payu.assessment.payuAssessment.repositories;

import org.springframework.data.repository.CrudRepository;

import com.payu.assessment.payuAssessment.model.Book;

public interface BookRepo extends CrudRepository<Book, String>{

	Book  findByIsbnNumber(String isbnNumber);
	
	Book findBookById(String id);
	
	Book findBookByName(String name);
	
	
	

}
