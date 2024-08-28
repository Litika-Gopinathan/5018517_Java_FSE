
package com.example.bookstoreapi.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookDTO {
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

    @NotNull
    @Size(min = 10, max = 13)
    private String isbn;

	public Long getId() {
		return id;
	}

	public BookDTO(Long id, @NotNull @Size(min = 2, max = 100) String title,
			@NotNull @Size(min = 2, max = 50) String author, @NotNull @Min(0) Double price,
			@NotNull @Size(min = 10, max = 13) String isbn) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
	}

	public BookDTO() {
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

	public void setId(Long id) {
		this.id = id;
	}

}
