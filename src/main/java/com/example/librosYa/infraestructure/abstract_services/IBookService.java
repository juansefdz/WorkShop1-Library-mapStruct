package com.example.librosYa.infraestructure.abstract_services;

import com.example.librosYa.application.dto.request.BookRequest;
import com.example.librosYa.application.dto.response.BookResponse;
import com.example.librosYa.infraestructure.abstract_services.generic.CreateService.*;
import org.springframework.stereotype.Service;

@Service
public interface IBookService extends
        CreateService<BookRequest,BookResponse>,
        DeleteService<Long>,                                //this is disable status
        ReadAllService<BookResponse>,
        ReadService<BookResponse,Long>,
        UpdateService<BookRequest,BookResponse, Long> {
}
