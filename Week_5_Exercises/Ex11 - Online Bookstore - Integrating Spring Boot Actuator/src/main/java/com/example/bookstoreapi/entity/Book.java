
package com.example.bookstoreapi.entity;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String title;

    @NotNull
    @Size(min = 2, max = 50)
    private String author;

    @NotNull
    @Min(0)
    private Double price;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public Book() {}
	
	public Book(Long id, @NotNull @Size(min = 2, max = 100) String title,
			@NotNull @Size(min = 2, max = 50) String author, @NotNull @Min(0) Double price,
			@NotNull @Size(min = 10, max = 13) String isbn, Integer version) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
		this.version = version;
	}

	@NotNull
    @Size(min = 10, max = 13)
    private String isbn;

    @Version 
    private Integer version;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
    
    

    
}
