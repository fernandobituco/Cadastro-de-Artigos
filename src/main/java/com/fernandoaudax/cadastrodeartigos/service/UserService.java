package com.fernandoaudax.cadastrodeartigos.service;

import com.fernandoaudax.cadastrodeartigos.schemas.*;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserCreateResponse save(UserCreateRequest user);

    List<UserReadResponse> findAll();

    UserReadResponse findById(UUID id);

    UserUpdateResponse update(UserUpdateRequest userUpdate, UUID id);

    void delete(UUID id);
}
