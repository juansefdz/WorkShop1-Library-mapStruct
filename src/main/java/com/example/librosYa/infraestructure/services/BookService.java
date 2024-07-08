package com.example.librosYa.infraestructure.services;

import com.example.librosYa.application.dto.request.BookRequest;
import com.example.librosYa.application.dto.response.BookResponse;
import com.example.librosYa.application.mappers.Book.BookMapper;
import com.example.librosYa.domain.entities.BookEntity;
import com.example.librosYa.domain.repositories.BookRepository;

import com.example.librosYa.infraestructure.abstract_services.IBookService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService implements IBookService {
    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final BookMapper bookMapper;

    @Override
    public Page<BookResponse> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable).map(bookMapper::toResponse);
    }

    @Override
    public Optional<BookResponse> getById(Long id) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(id);
        return bookEntityOptional.map(bookMapper::toResponse);
    }

    @Override
    @Transactional
    public BookResponse create(BookRequest bookRequest) {
        BookEntity bookEntity = bookMapper.toEntity(bookRequest);
        BookEntity savedBookEntity = bookRepository.save(bookEntity);
        return bookMapper.toResponse(savedBookEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        BookEntity bookEntity = find(id);
        bookRepository.delete(bookEntity);
    }

    private BookEntity find(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
    }

    @Override
    @Transactional
    public BookResponse update(Long id, BookRequest bookRequest) {
        BookEntity bookEntity = find(id);
        bookMapper.updateEntityFromDto(bookRequest, bookEntity);
        BookEntity updatedBookEntity = bookRepository.save(bookEntity);
        return bookMapper.toResponse(updatedBookEntity);
    }
}
