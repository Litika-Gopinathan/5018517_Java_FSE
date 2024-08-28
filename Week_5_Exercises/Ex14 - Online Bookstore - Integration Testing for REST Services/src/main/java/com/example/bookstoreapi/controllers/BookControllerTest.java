package com.example.bookstoreapi.controllers;

import com.example.bookstoreapi.controllers.BookController;
import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        // MockMvc setup, if needed
    }

    @Test
    public void testGetAllBooks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetBookById() throws Exception {
        // Mock data setup
        BookDTO bookDTO = new BookDTO(1L, "Title", "Author", 10.0, "1234567890");
        when(bookService.getBookById(1L)).thenReturn(bookDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Title"));
    }

    @Test
    public void testCreateBook() throws Exception {
        // Mock data setup
        BookDTO bookDTO = new BookDTO(null, "New Title", "New Author", 15.0, "0987654321");
        when(bookService.createBook(any(BookDTO.class))).thenReturn(bookDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookDTO)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("New Title"));
    }

    @Test
    public void testUpdateBook() throws Exception {
        // Mock data setup
        BookDTO bookDTO = new BookDTO(1L, "Updated Title", "Updated Author", 20.0, "1234567890");
        when(bookService.updateBook(eq(1L), any(BookDTO.class))).thenReturn(bookDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/books/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookDTO)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Updated Title"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/books/1"))
                .andExpect(status().isNoContent());
    }
}
