package com.example.bookstoreapi.controllers;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // GET all books with HATEOAS links
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks().stream()
            .map(bookDTO -> addHateoasLinks(bookDTO))
            .collect(Collectors.toList());
        return ResponseEntity.ok(books);
    }
    
    @GetMapping
    public ResponseEntity<CollectionModel<BookDTO>> getAllBooks(@RequestParam(required = false) Integer page, 
                                                                @RequestParam(required = false) Integer size) {
        List<BookDTO> books = bookService.getAllBooks().stream()
            .map(this::addHateoasLinks)
            .collect(Collectors.toList());

        CollectionModel<BookDTO> collectionModel = CollectionModel.of(books);
        Link nextPageLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks(page + 1, size)).withRel("next");
        Link prevPageLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks(page - 1, size)).withRel("prev");
        collectionModel.add(nextPageLink, prevPageLink);

        return ResponseEntity.ok(collectionModel);
    }


    // GET a book by ID with HATEOAS links
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        BookDTO book = bookService.getBookById(id);
        addHateoasLinks(book);
        return ResponseEntity.ok(book);
    }

    // POST a new book
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO savedBook = bookService.createBook(bookDTO);
        addHateoasLinks(savedBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    // PUT update a book by ID
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBook(id, bookDTO);
        addHateoasLinks(updatedBook);
        return ResponseEntity.ok(updatedBook);
    }

    // DELETE a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // Helper method to add HATEOAS links
    private BookDTO addHateoasLinks(BookDTO bookDTO) {
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(bookDTO.getId())).withSelfRel();
        bookDTO.add(selfLink);
        return bookDTO;
    }
}
