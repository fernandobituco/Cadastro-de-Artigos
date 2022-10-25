package com.fernandoaudax.cadastrodeartigos.service;

import com.fernandoaudax.cadastrodeartigos.repository.UserRepository;
import com.fernandoaudax.cadastrodeartigos.schemas.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements  UserService{
    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserCreateResponse save(UserCreateRequest user) {
        return null;
    }

    @Override
    public List<UserReadResponse> findAll() {
        return null;
    }

    @Override
    public UserReadResponse findById(UUID id) {
        return null;
    }

    @Override
    public UserUpdateResponse update(UserUpdateRequest userUpdate, UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
