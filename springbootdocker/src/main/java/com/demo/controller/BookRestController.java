package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.AppConstants;
import com.demo.Status;
import com.demo.entity.Book;
import com.demo.service.BookServiceRepo;

@RestController
@RequestMapping("/books")
public class BookRestController {

	@Autowired
    private BookServiceRepo bookService;
 	// other parts are same

	@GetMapping
    public List<Book> getBooks(@RequestParam(required=false) String author){
		 if(author!=null)
	            return bookService.getBooksByAuthor(author);
    	return bookService.getAllBooks();
     }
	@GetMapping("/{id}")
	public ResponseEntity<Object>  getBookById(int id){
		Map<String, Object> map = new HashMap<>();
	    try {
	        map.put(AppConstants.STATUS, Status.SUCCESS);
	        map.put("book",bookService.getBookById(id) );
	        return ResponseEntity.ok(map);
	    }
	    catch (RuntimeException e){
	        map.put(AppConstants.STATUS, Status.FAILURE);
	        map.put("error",e.getMessage());
	        return ResponseEntity.badRequest().body(map);
	    }
	}
	
	@PostMapping
	public ResponseEntity<Object> addBook(@RequestBody Book book){
	    System.out.println("Book "+book);
	    Map<String, Object> map = new HashMap<>();
	    try {
	        map.put(AppConstants.STATUS, Status.SUCCESS);
	        Book booksaved = bookService.addNewBook(book);
	        System.out.println("saved book "+booksaved);
	        map.put("book", booksaved);
	        return ResponseEntity.ok(map);
	    }
	    catch (RuntimeException e){
	        map.put(AppConstants.STATUS, Status.FAILURE);
	        map.put("error",e.getMessage());
	        return ResponseEntity.badRequest().body(map);
	    }
	}



}
