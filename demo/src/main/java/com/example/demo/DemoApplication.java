package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.entity.Book;
import com.example.demo.entity.Student;
import com.example.demo.service.BookServiceRepo;
/**
 * 1. is an opinionated framework
 * in-memory or embedded DB? -> 
 * Db server, appn (server) ,clients
 * 
 * ORM - Object Relational Mapping
 * class Book -> book table
 * save(book)
 * 
 * @EnableAutoConfiguration : 
 * @ConponentScan : 
 * @SpringBootconfiguration : spring boot
 * 
 * a. 1
 * b. 2
 * c. 1,2
 * d. error
 * e. no output
 */
@SpringBootApplication
//@ComponentScan({"beans", "com.example.demo"})
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		BookServiceRepo bookServiceRepo = context.getBean(BookServiceRepo.class);
		System.out.println(bookServiceRepo.getTotalBookCount());
		Book b1 = new Book("Java", "Shalin", "Learn java ", 230);
		Book b2 = new Book("CSS", "Head Start", "Learn CSS 3 ", 130);
		System.out.println("Inserted "+bookServiceRepo.addNewBook(b1));
		System.out.println("Inserted "+bookServiceRepo.addNewBook(b2));
		System.out.println(bookServiceRepo.getTotalBookCount());
	}
}
