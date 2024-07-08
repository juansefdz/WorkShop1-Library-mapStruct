package com.example.librosYa.infraestructure.abstract_services.generic.CreateService;

public interface CreateService <Request, Response>{
    Response create (Request request);
}
