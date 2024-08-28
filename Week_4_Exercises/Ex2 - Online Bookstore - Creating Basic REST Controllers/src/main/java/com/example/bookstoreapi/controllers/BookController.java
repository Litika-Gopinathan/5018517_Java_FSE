package com.example.bookstoreapi.controllers;

import com.example.bookstoreapi.entity.Book;  // Import the Book class
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;  // Import ArrayList
import java.util.List;       // Import List

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>(); // Declare and initialize the list of books

    // GET all books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // POST a new book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        book.setId((long) (books.size() + 1)); 
        books.add(book);
        return book;
    }

    // PUT to update a book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                book.setIsbn(updatedBook.getIsbn());
                return book;
            }
        }
        throw new RuntimeException("Book not found");
    }

    // DELETE a book by ID
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
        return "Book with ID " + id + " has been deleted.";
    }
}
