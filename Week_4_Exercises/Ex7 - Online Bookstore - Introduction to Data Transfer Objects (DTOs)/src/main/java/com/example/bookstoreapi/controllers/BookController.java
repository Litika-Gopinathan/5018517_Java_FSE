package com.example.bookstoreapi.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.bookstoreapi.entity.Book;
import com.example.bookstoreapi.exception.BookNotFoundException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();    

    // GET book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found"));
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title is required");
        }
        book.setId((long) (books.size() + 1));
        books.add(book);
        return book;
    }

}
