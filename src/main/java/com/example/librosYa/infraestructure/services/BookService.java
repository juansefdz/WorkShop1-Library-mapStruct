package com.example.librosYa.infraestructure.services;

import com.example.librosYa.application.dto.request.BookRequest;
import com.example.librosYa.application.dto.response.BookResponse;
import com.example.librosYa.application.mappers.BookMapper;
import com.example.librosYa.domain.entities.BookEntity;
import com.example.librosYa.domain.repositories.BookRepository;
import com.example.librosYa.infraestructure.abstract_services.CRUDService;
import com.example.librosYa.infraestructure.abstract_services.IBookService;
import com.example.librosYa.infraestructure.abstract_services.ILoanService;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Page<BookResponse> getAll(int page, int size) {
        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return bookRepository.findAll(pagination).map(bookMapper::toGetDTO);
    }

    @Override
    public BookResponse getById(Long id) {
        BookEntity bookEntity = find(id);
        return bookMapper.toGetDTO(bookEntity);
    }

    @Override
    public BookResponse create(BookRequest bookRequest) {
        BookEntity bookEntity = bookMapper.toEntity(bookRequest);
        BookEntity savedBook = bookRepository.save(bookEntity);
        return bookMapper.toGetDTO(savedBook);
    }

    @Override
    public BookResponse update(BookRequest bookRequest, Long id) {
        BookEntity bookEntity = find(id);
        bookMapper.updateEntityFromDto(bookRequest, bookEntity);
        BookEntity updatedBook = bookRepository.save(bookEntity);
        return bookMapper.toGetDTO(updatedBook);
    }

    @Override
    public void delete(Long id) {
        BookEntity bookEntity = find(id);
        bookRepository.delete(bookEntity);
    }

    private BookEntity find(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
    }
}
