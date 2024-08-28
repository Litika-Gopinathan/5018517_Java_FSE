package com.example.bookstoreapi.serializer;

import com.example.bookstoreapi.entity.Book;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class CustomBookSerializer extends JsonSerializer<Book> {
    @Override
    public void serialize(Book book, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("title", book.getTitle());
        gen.writeStringField("author", book.getAuthor());
        gen.writeEndObject();
    }
}
