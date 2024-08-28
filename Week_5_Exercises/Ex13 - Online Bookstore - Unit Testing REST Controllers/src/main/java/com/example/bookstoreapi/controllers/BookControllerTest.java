package com.example.bookstoreapi.controllers;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void testGetAllBooks() throws Exception {
        BookDTO book1 = new BookDTO(1L, "Book 1", "Author 1", 9.99, "1234567890");
        BookDTO book2 = new BookDTO(2L, "Book 2", "Author 2", 19.99, "0987654321");

        List<BookDTO> books = Arrays.asList(book1, book2);

        when(bookService.getAllBooks()).thenReturn(books);

        mockMvc.perform(MockMvcRequestBuilders.get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':1,'title':'Book 1'},{'id':2,'title':'Book 2'}]"));
    }

    @Test
    public void testGetBookById() throws Exception {
        BookDTO book = new BookDTO(1L, "Book 1", "Author 1", 9.99, "1234567890");

        when(bookService.getBookById(1L)).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':1,'title':'Book 1'}"));
    }

    @Test
    public void testCreateBook() throws Exception {
        BookDTO book = new BookDTO(null, "Book 1", "Author 1", 9.99, "1234567890");
        BookDTO savedBook = new BookDTO(1L, "Book 1", "Author 1", 9.99, "1234567890");

        when(bookService.createBook(any(BookDTO.class))).thenReturn(savedBook);

        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Book 1\",\"author\":\"Author 1\",\"price\":9.99,\"isbn\":\"1234567890\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().json("{'id':1,'title':'Book 1'}"));
    }

    @Test
    public void testUpdateBook() throws Exception {
        BookDTO updatedBook = new BookDTO(1L, "Updated Book", "Updated Author", 19.99, "1234567890");

        when(bookService.updateBook(eq(1L), any(BookDTO.class))).thenReturn(updatedBook);

        mockMvc.perform(MockMvcRequestBuilders.put("/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Updated Book\",\"author\":\"Updated Author\",\"price\":19.99,\"isbn\":\"1234567890\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':1,'title':'Updated Book'}"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        Mockito.doNothing().when(bookService).deleteBook(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/books/1"))
                .andExpect(status().isNoContent());
    }
}

