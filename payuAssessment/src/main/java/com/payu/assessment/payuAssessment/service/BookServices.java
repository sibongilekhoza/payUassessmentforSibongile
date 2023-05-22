package com.payu.assessment.payuAssessment.service;

import java.util.List;

import com.payu.assessment.payuAssessment.exceptions.NotFoundException;
import com.payu.assessment.payuAssessment.items.BookItem;
import com.payu.assessment.payuAssessment.model.Book;
import com.payu.assessment.payuAssessment.request.SaveBookRequest;
import com.payu.assessment.payuAssessment.request.UpdateBookRequest;

public interface BookServices 
{
   BookItem saveBook(SaveBookRequest bookRequest) throws NotFoundException;
   Book save(Book book)throws NotFoundException;
   List<Book>getAllBook()throws NotFoundException;
   
   Book getBookByName(String name) throws NotFoundException;
   
   Book getBook(String id) throws NotFoundException;
   
   void delete(String id);
   void delete();
   
   Book getBookByIsbn(String isbnNumber) throws NotFoundException;
   
   Book updateBook(UpdateBookRequest request) throws NotFoundException;
   
   Book editbook(Book book) throws NotFoundException;
   
   Book deleteBook(String id) throws NotFoundException;

}
