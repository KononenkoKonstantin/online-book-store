package org.example.onlinebookstore.service;

import java.util.List;
import org.example.onlinebookstore.dto.BookDto;
import org.example.onlinebookstore.dto.CreateBookRequestDto;

public interface BookService {
    List<BookDto> findAll();

    BookDto findById(Long id);

    BookDto save(CreateBookRequestDto requestDto);

    BookDto updateById(Long id, CreateBookRequestDto requestDto);

    void deleteById(Long id);
}
