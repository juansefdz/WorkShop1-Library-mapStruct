package com.example.librosYa.infraestructure.abstract_services;

import org.springframework.data.domain.Page;

public interface CRUDService <REQUEST,RESPONSE, TYPE> {
    Page<RESPONSE> getAll (int page, int size);

    RESPONSE getById (TYPE id);
    RESPONSE create (REQUEST  dtoRequest);
    RESPONSE update (REQUEST  dtoRequest, TYPE id);
    void delete (TYPE id);

}
