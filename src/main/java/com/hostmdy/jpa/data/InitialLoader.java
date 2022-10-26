package com.hostmdy.jpa.data;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.hostmdy.jpa.entity.Author;
import com.hostmdy.jpa.entity.Book;
import com.hostmdy.jpa.repository.AuthorRepository;
import com.hostmdy.jpa.repository.BookRepository;

@Component
public class InitialLoader implements ApplicationListener<ApplicationEvent>{
	
	private BookRepository bookRepo;
	private AuthorRepository authorRepo;

	public InitialLoader(BookRepository bookRepo, AuthorRepository authorRepo) {
		super();
		this.bookRepo = bookRepo;
		this.authorRepo = authorRepo;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		initialize();
	}

	private void initialize() {
		Book book1 = new Book("Domain Driven","Programming", 34.6);
		Author author1 = new Author("John", "Evan", 60, "je@gmail.com");
		//Many to Many Connect
		book1.getAuthors().add(author1);
		author1.getBooks().add(book1);
		authorRepo.save(author1); //Create/Insert
		bookRepo.save(book1); //Create/Insert
	
		
		Book book2 = new Book("Action Java","Programming", 44.6);
		Author author2 = new Author("Franklins", "Evan", 60, "fa@gmail.com");
		//Many to Many Connect
		book2.getAuthors().add(author2);
		author2.getBooks().add(book2);
		bookRepo.save(book2); //Create/Insert
		authorRepo.save(author2); //Create/Insert
//		
//		
		Book book3 = new Book("Model Design","Programming", 94.6);
		Author author3 = new Author("Susan", "Evan", 50, "ss@gmail.com");
		//Many to Many Connect
		book3.getAuthors().add(author3);
		bookRepo.save(book3); //Create/Insert
		author3.getBooks().add(book3);
		authorRepo.save(author3); //Create/Insert
//		
	}
}
