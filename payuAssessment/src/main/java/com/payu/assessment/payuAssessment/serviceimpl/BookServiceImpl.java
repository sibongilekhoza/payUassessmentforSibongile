package com.payu.assessment.payuAssessment.serviceimpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payu.assessment.payuAssessment.enums.HttpStatusEnum;
import com.payu.assessment.payuAssessment.exceptions.NotFoundException;
import com.payu.assessment.payuAssessment.items.BookItem;
import com.payu.assessment.payuAssessment.model.Book;
import com.payu.assessment.payuAssessment.repositories.BookRepo;
import com.payu.assessment.payuAssessment.request.SaveBookRequest;
import com.payu.assessment.payuAssessment.request.UpdateBookRequest;
import com.payu.assessment.payuAssessment.service.BookServices;
import com.payu.assessment.payuAssessment.service.CommonService;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class BookServiceImpl implements BookServices {
	
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private CommonService service;
	


	
	@Transactional
	@Override
	public BookItem saveBook(SaveBookRequest bookRequest) throws NotFoundException {
		
		Book book;
		BookItem bookItem  = new BookItem();
		
		
		
		book = bookRepo.findByIsbnNumber(bookRequest.getIsbnNumber());
			System.out.println("book found" + book);
		if (book == null)
		{
		
			System.out.println("data to save" + bookRequest);
			log.info("Register the Book");
			book= new Book().setId(service.getUniqueId()).setIsbnNumber(bookRequest.getIsbnNumber()).setName(bookRequest.getName()).
					    setPrice(bookRequest.getPrice()).setPublishDate(bookRequest.getPublishDate()).setBook_type(bookRequest.getBook_type());
			
			book = bookRepo.save(book);
			
			BeanUtils.copyProperties(book, bookItem);
			return bookItem;
		}
		else
		{
			throw new NotFoundException().setResponseCode(HttpStatusEnum.DUPLICATES.getCode())
			.setDeveloperMessage(service.getMessage(HttpStatusEnum.DUPLICATES.getKey(), "Book",bookRequest.getIsbnNumber()))
			.setResponseMessage(HttpStatusEnum.DUPLICATES.getDeveloperMessage())
			.setStatusCode(HttpStatus.BAD_REQUEST);
		}
		
			
		
	}

	@Override
	public Book updateBook(UpdateBookRequest request) throws NotFoundException {
		
		Book book = bookRepo.findByIsbnNumber(request.getIsbnNumber());
		if(book != null)
		{
			book.setName(request.getName()).setPrice(request.getPrice()).setPublishDate(request.getPublishDate());
			
		   book = bookRepo.save(book);
		   
		   BookItem bookItem = new BookItem();
			BeanUtils.copyProperties(book, bookItem);
			
			return book;
		}
		else
		{
			throw new NotFoundException().setResponseCode(HttpStatusEnum.NO_DATA_FOUND.getCode())
			.setDeveloperMessage(service.getMessage(HttpStatusEnum.NO_DATA_FOUND.getKey(), "Book not found",request.getIsbnNumber()))
			.setResponseMessage(HttpStatusEnum.NO_DATA_FOUND.getDeveloperMessage())
			.setStatusCode(HttpStatus.BAD_REQUEST);
		}
		
		
		
	}

	
	@Override
	public Book editbook(Book book) throws NotFoundException {

		if(book !=null)
		{
			
			 bookRepo.save(book);
		}
		
		
		return book;
	}


	
	@Override
	public Book deleteBook(String id) throws NotFoundException {
		Book book = bookRepo.findBookById(id);
		bookRepo.delete(book);
		
		return book;
	}

	@Override
	public List<Book> getAllBook() throws NotFoundException {

		List<Book> books = (List<Book>) bookRepo.findAll();
		
		return books;
	}

	@Override
	public Book getBookByName(String name) throws NotFoundException {
	
		Book book = bookRepo.findBookByName(name);
		System.out.println("book found " + book);
		if(book != null)
		{
			System.out.println("book found " + book);
			return book;
		}
		else
		{
			throw new NotFoundException().setResponseCode(HttpStatusEnum.NO_DATA_FOUND.getCode())
			.setDeveloperMessage(
					service.getMessage(HttpStatusEnum.NO_DATA_FOUND.getKey(), "book nmae ", name))
			.setResponseMessage(HttpStatusEnum.NO_DATA_FOUND.getDeveloperMessage())
			.setStatusCode(HttpStatus.NOT_FOUND);
		}
		
		
		
	}

	@Override
	public Book getBookByIsbn(String isbnNumber) throws NotFoundException {
		Book book = bookRepo.findByIsbnNumber(isbnNumber);
		System.out.println("book found" + book);
		
		if(book != null)
		{
			
			System.out.println("book found " + book);
			return book;
		}
		else {
			throw new NotFoundException().setResponseCode(HttpStatusEnum.NO_DATA_FOUND.getCode())
			.setDeveloperMessage(
					service.getMessage(HttpStatusEnum.NO_DATA_FOUND.getKey(), " ISBN Number", isbnNumber))
			.setResponseMessage(HttpStatusEnum.NO_DATA_FOUND.getDeveloperMessage())
			.setStatusCode(HttpStatus.NOT_FOUND);
		}
		
		
	}

	@Override
	public Book save(Book book) throws NotFoundException {
		if(book !=null)
		{
			book.setId(service.getUniqueId());
			book = bookRepo.save(book);
		}
		
		
		return book;
	}

	@Override
	public Book getBook(String id) throws NotFoundException {
		
		Book book = bookRepo.findBookById(id);
		
		return book;
	}

	@Override
	public void delete(String id) {
		
		
		bookRepo.deleteById(id);
		
	}

	@Override
	public void delete() {
	
		bookRepo.deleteAll();
	}

	


	




	

}
