package com.example.librosYa.infraestructure.abstract_services;

import com.example.librosYa.application.dto.request.UserRequest;
import com.example.librosYa.application.dto.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface IUserService extends CRUDService<UserRequest, UserResponse,Long>{
}
