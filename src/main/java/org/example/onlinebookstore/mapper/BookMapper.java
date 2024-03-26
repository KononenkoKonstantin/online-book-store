package org.example.onlinebookstore.mapper;

import org.example.onlinebookstore.dto.BookDto;
import org.example.onlinebookstore.dto.CreateBookRequestDto;
import org.example.onlinebookstore.model.Book;

public interface BookMapper {
    BookDto toDto(Book book);
    Book toModel(CreateBookRequestDto requestDto);
}
