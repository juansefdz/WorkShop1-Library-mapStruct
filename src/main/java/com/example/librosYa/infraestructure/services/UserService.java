package com.example.librosYa.infraestructure.services;

import com.example.librosYa.application.dto.request.UserRequest;
import com.example.librosYa.application.dto.response.UserResponse;
import com.example.librosYa.domain.entities.UserEntity;
import com.example.librosYa.domain.repositories.UserRepository;
import com.example.librosYa.infraestructure.abstract_services.CRUDService;
import com.example.librosYa.application.mappers.UserMapper;
import com.example.librosYa.infraestructure.abstract_services.IUserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Page<UserResponse> getAll(int page, int size) {
        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return userRepository.findAll(pagination).map(userMapper::toGetDTO);
    }

    @Override
    public UserResponse getById(Long id) {
        UserEntity userEntity = find(id);
        return userMapper.toGetDTO(userEntity);
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        UserEntity userEntity = userMapper.toEntity(userRequest);
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toGetDTO(savedUser);
    }

    @Override
    public UserResponse update(UserRequest userRequest, Long id) {
        UserEntity userEntity = find(id);
        userMapper.updateEntityFromDto(userRequest, userEntity);
        UserEntity updatedUser = userRepository.save(userEntity);
        return userMapper.toGetDTO(updatedUser);
    }

    @Override
    public void delete(Long id) {
        UserEntity userEntity = find(id);
        userRepository.delete(userEntity);
    }

    private UserEntity find(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }
}
