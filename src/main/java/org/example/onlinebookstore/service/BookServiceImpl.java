package org.example.onlinebookstore.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.onlinebookstore.dto.BookDto;
import org.example.onlinebookstore.dto.CreateBookRequestDto;
import org.example.onlinebookstore.exception.EntityNotFoundException;
import org.example.onlinebookstore.mapper.BookMapper;
import org.example.onlinebookstore.model.Book;
import org.example.onlinebookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream().map(bookMapper::toDto).toList();
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find book by id=" + id));
        return bookMapper.toDto(book);
    }
}
