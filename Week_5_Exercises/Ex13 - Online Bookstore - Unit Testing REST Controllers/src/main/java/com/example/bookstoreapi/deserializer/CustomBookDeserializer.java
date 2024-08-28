package com.example.bookstoreapi.deserializer;

import com.example.bookstoreapi.entity.Book;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class CustomBookDeserializer extends JsonDeserializer<Book> {
    @Override
    public Book deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return new Book();
    }
}

