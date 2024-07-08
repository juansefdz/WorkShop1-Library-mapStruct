package com.example.librosYa.infraestructure.abstract_services.generic.CreateService;

public interface UpdateService<Request, Response, Id> {
    Response update(Id id, Request request);
}