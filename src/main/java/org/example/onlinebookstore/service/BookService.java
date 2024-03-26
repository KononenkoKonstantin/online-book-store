package org.example.onlinebookstore.service;

import java.util.List;
import org.example.onlinebookstore.dto.BookDto;
import org.example.onlinebookstore.dto.CreateBookRequestDto;
import org.example.onlinebookstore.model.Book;

public interface BookService {
    List<BookDto> findAll();

    BookDto findById(Long id);

    BookDto save(CreateBookRequestDto requestDto);

}
