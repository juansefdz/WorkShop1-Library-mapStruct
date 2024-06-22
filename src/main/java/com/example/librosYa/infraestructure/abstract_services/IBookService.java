package com.example.librosYa.infraestructure.abstract_services;

import com.example.librosYa.application.dto.request.BookRequest;
import com.example.librosYa.application.dto.response.BookResponse;
import org.springframework.stereotype.Service;

@Service
public interface IBookService extends CRUDService <BookRequest, BookResponse,Long>{
}
