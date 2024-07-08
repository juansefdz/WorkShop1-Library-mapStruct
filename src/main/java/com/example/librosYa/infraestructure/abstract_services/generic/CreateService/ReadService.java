package com.example.librosYa.infraestructure.abstract_services.generic.CreateService;

import java.util.Optional;

public interface ReadService<Response, Id> {
    Optional<Response> getById(Id id);
}