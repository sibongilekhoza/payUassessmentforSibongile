package com.payu.assessment.payuAssessment.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.payu.assessment.payuAssessment.enums.HttpStatusEnum;
import com.payu.assessment.payuAssessment.exceptions.NotFoundException;
import com.payu.assessment.payuAssessment.items.BookItem;
import com.payu.assessment.payuAssessment.model.Book;
import com.payu.assessment.payuAssessment.request.SaveBookRequest;
import com.payu.assessment.payuAssessment.request.UpdateBookRequest;
import com.payu.assessment.payuAssessment.response.BookResponse;
import com.payu.assessment.payuAssessment.response.GetAllBooksResponse;
import com.payu.assessment.payuAssessment.response.GetBookResponse;
import com.payu.assessment.payuAssessment.response.SaveBookResponse;
import com.payu.assessment.payuAssessment.service.BookServices;
import com.payu.assessment.payuAssessment.service.CommonService;

@Controller
public class BookController
{
	@Autowired
	private CommonService service;

	@Autowired
	private Environment env;
	
	@Autowired
	private BookServices bookService;
	
	
	
	@RequestMapping(value = "/bookform", method =RequestMethod.GET )
	public String RegistaPage(ModelMap model)

	{
		Book book = new Book();
		model.addAttribute("book", book);
		
			 
		return "bookform";
	}
	@ModelAttribute(value = "/book_type")
	public List<String> bookType(ModelMap model)

	{
		List<String> book_type = new ArrayList<String>();
		book_type.add("Hard_Cover");
		book_type.add("Soft_Cover");
		book_type.add("eBook");
		book_type.add("OTHER");
		
			  
		return book_type;
	}
	
	
	
	
	@PostMapping("/bookRegistration")
	public ResponseEntity<?> bookRegista(@RequestBody SaveBookRequest request,BindingResult bindingResult) throws NotFoundException

	{
		
		
		
		 return ResponseEntity.ok(new SaveBookResponse().setBook(bookService.saveBook(request))
				 .setResponseCode(HttpStatusEnum.SUCCESSFUL.getCode())
				 .setDeveloperMessage(HttpStatusEnum.SUCCESSFUL.getDeveloperMessage())
				// .setResponseMessage(service.getMessage(HttpStatusEnum.SUCCESSFUL.getKey(), "Register"))
				 );		 
		
	}
	
	@RequestMapping(value ="/save",method = RequestMethod.POST)
	public String savebook(Book book,BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) throws NotFoundException

	{
		
		if (result.hasErrors()) {
			return "bookform";
		}
		
		
		bookService.save(book);
			 return "redirect:/viewbooks";
		
	}
	@GetMapping("/GetAllBooks")
	public ResponseEntity<?> getAllBooks() throws NotFoundException
	{
		
		return ResponseEntity.ok(new GetAllBooksResponse().setBooks(bookService.getAllBook())
				.setResponseCode(HttpStatusEnum.SUCCESSFUL.getCode())
				.setDeveloperMessage(HttpStatusEnum.SUCCESSFUL.getDeveloperMessage())
				//.setResponseMessage(service.getMessage(HttpStatusEnum.SUCCESSFUL.getKey(), "Register"))
				 );
		
	}
	
	@RequestMapping("/viewbooks")
	public ModelAndView viewBooks() throws NotFoundException
	{
		List<Book> books = bookService.getAllBook();
		
		return new ModelAndView("viewbooks","books",books);
		
	}

	@GetMapping("/GetBookByName")
	public ResponseEntity<?> getBookByName(String name) throws NotFoundException
	{
		
		return ResponseEntity.ok(new BookResponse().setBook(bookService.getBookByName(name))
				.setResponseCode(HttpStatusEnum.SUCCESSFUL.getCode())
				.setDeveloperMessage(HttpStatusEnum.SUCCESSFUL.getDeveloperMessage())
				//.setResponseMessage(service.getMessage(HttpStatusEnum.SUCCESSFUL.getKey(), "book"))
				 );
		
	}
	
	
	@GetMapping("/GetBookByIsbn")
	public ResponseEntity<?> getBookByIsbn(String isbnNumber) throws NotFoundException
	{
		
		return ResponseEntity.ok(new BookResponse().setBook(bookService.getBookByIsbn(isbnNumber))
				.setResponseCode(HttpStatusEnum.SUCCESSFUL.getCode())
				.setDeveloperMessage(HttpStatusEnum.SUCCESSFUL.getDeveloperMessage())
				//.setResponseMessage(service.getMessage(HttpStatusEnum.SUCCESSFUL.getKey(), "book"))
				 );
		
	}
	
	 @RequestMapping(value="/edit",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("book") Book book) throws NotFoundException{  
	    	System.out.println("id is"+book.getId());
	    	bookService.editbook(book);
	        return new ModelAndView("redirect:/viewbooks");  
	    } 
	 
	 @RequestMapping(value="/editbook/{id}")  
	    public ModelAndView editbook(@PathVariable String id,ModelMap model) throws NotFoundException{  
		 Book book = bookService.getBook(id);
		 model.addAttribute("book", book);
	    	
	        return new ModelAndView("redirect:/viewbooks");  
	    } 
	

	@PutMapping("/updateBook")
	public ResponseEntity<?> updateBookInfor(@RequestBody  UpdateBookRequest request, BindingResult bindingResult) throws BeansException, NotFoundException
	{
		service.validateRequest(bindingResult);
		BookItem reponse = new BookItem();
		BeanUtils.copyProperties(bookService.updateBook(request),reponse);
		
		return ResponseEntity.ok(new GetBookResponse().setBook(reponse).setResponseCode(HttpStatusEnum.SUCCESSFUL.getCode())
				.setDeveloperMessage(HttpStatusEnum.SUCCESSFUL.getDeveloperMessage())
				//.setResponseMessage(service.getMessage(HttpStatusEnum.SUCCESSFUL.getKey(),"Updated book details"))
				);
	}
	
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<?> deletebook(@PathVariable String id) throws NotFoundException
	{
		return ResponseEntity.ok(new BookResponse().setBook(bookService.deleteBook(id))
				.setResponseCode(HttpStatusEnum.SUCCESSFUL.getCode())
				.setDeveloperMessage(HttpStatusEnum.SUCCESSFUL.getDeveloperMessage())
				//.setResponseMessage(service.getMessage(HttpStatusEnum.SUCCESSFUL.getKey(), "Book Deleted"))
				);
	}
	
	  @RequestMapping(value="/deletebook/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable String id){  
	    	bookService.delete(id);  
	        return new ModelAndView("redirect:/viewbooks");  
	    }  
	    
	    /* It deletes record for the given id  and redirects to /viewstudents */  
	    @RequestMapping(value="/delete",method = RequestMethod.GET)  
	    public ModelAndView delete(){  
	    	bookService.delete();  
	        return new ModelAndView("redirect:/bookform");  
	    } 

	
}
