package com.adminportal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adminportal.domain.Book;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@GetMapping("/add")
	public String addBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "addBook";
	}
	
	@PostMapping("/add")
	public String addBookPost(
			@ModelAttribute("book") Book book, HttpServletRequest request
			) {
		bookService.save(book);
		
		return "addBook";
	}
	

}
