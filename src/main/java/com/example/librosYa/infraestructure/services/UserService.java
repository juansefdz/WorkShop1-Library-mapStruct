package com.example.librosYa.infraestructure.services;

import com.example.librosYa.application.dto.request.UserRequest;
import com.example.librosYa.application.dto.response.UserResponse;
import com.example.librosYa.domain.entities.UserEntity;
import com.example.librosYa.domain.repositories.UserRepository;
import com.example.librosYa.application.mappers.User.UserMapper;
import com.example.librosYa.infraestructure.abstract_services.IUserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserMapper userMapper;

   

    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(this.userMapper::toResponse);
    }


    @Override
    public Optional<UserResponse> getById(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        return userEntityOptional.map(userMapper::toResponse);
    }

    @Override
    @Transactional
    public UserResponse create(UserRequest userRequest) {
        UserEntity userEntity = userMapper.toEntity(userRequest);
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toResponse(savedUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        UserEntity userEntity = find(id);
        userRepository.delete(userEntity);
    }

    private UserEntity find(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    @Override
    @Transactional
    public UserResponse update(Long id, UserRequest userRequest) {
        UserEntity userEntity = find(id);
        userMapper.updateEntityFromDto(userRequest, userEntity);
        UserEntity updatedUser = userRepository.save(userEntity);
        return userMapper.toResponse(updatedUser);
    }
}
