package com.example.librosYa.infraestructure.abstract_services;

import org.springframework.data.domain.Page;

public interface CRUDService <DTO, TYPE> {
    Page<DTO> getAll (int page, int size);

    DTO getById (TYPE id);
    DTO create (DTO dtoRequest);
    DTO update (DTO dtoRequest, TYPE id);
    void delete (TYPE id);

}
