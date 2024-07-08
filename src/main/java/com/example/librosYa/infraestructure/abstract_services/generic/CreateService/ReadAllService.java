package com.example.librosYa.infraestructure.abstract_services.generic.CreateService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReadAllService<Response> {
    Page<Response> getAll(Pageable pageable);
}