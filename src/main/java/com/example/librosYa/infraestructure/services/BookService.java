package com.example.librosYa.infraestructure.services;

import com.example.librosYa.api.dto.DtoBook;
import com.example.librosYa.infraestructure.abstract_services.IBookService;
import org.springframework.data.domain.Page;

public class BookService implements IBookService {
    @Override
    public Page<DtoBook> getAll(int page, int size) {
        return null;
    }

    @Override
    public DtoBook getById(Long id) {
        return null;
    }

    @Override
    public DtoBook create(DtoBook dtoRequest) {
        return null;
    }

    @Override
    public DtoBook update(DtoBook dtoRequest, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
