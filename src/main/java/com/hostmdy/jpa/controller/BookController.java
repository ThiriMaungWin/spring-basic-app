package com.hostmdy.jpa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hostmdy.jpa.entity.Book;
import com.hostmdy.jpa.repository.BookRepository;


@Controller
public class BookController {
	private BookRepository bookRepo;

	public BookController(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}
	
	//Use model when you want to give data to UI
	
	@RequestMapping("/book")
	private String showBookList(Model model) {
		List<Book> bookList = (List<Book>) bookRepo.findAll();
		model.addAttribute("bookList",bookList);
		return "book-list";
		
	}
}
