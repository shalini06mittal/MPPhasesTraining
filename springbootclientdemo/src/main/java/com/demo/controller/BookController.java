package com.demo.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.demo.model.Book;

@Controller
public class BookController {

	@GetMapping("/add")
	public String getBookForm() {
		return "bookform";
	}
	@PostMapping("/add")
	public String addNewBook(@ModelAttribute Book book) {
		System.out.println(book);
		try {
			RestTemplate template = new RestTemplate();
			
			Book bookresponse = template.postForObject("http://localhost:8080/books", book, Book.class);
			System.out.println(bookresponse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:list";
	}
	@GetMapping("/list")
	public String getBooks(Model model) {
			RestTemplate template = new RestTemplate();
			ResponseEntity<List<Book>> response = template.exchange("http://localhost:8080/books",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
            });
			System.out.println(response.getBody());
			model.addAttribute("books", response.getBody());
			return "booklist";
		
	}
	


}
