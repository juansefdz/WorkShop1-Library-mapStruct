package com.example.librosYa.infraestructure.abstract_services;

import com.example.librosYa.application.dto.request.UserRequest;
import com.example.librosYa.application.dto.response.UserResponse;
import com.example.librosYa.infraestructure.abstract_services.generic.CreateService.*;
import org.springframework.stereotype.Service;

@Service
public interface IUserService extends
        CreateService<UserRequest, UserResponse>,
        DeleteService<Long>,
        ReadAllService<UserResponse>,
        ReadService<UserResponse,Long>,
        UpdateService<UserRequest,UserResponse, Long> {
}
