package com.fernandoaudax.cadastrodeartigos.service;

import com.fernandoaudax.cadastrodeartigos.entity.User;
import com.fernandoaudax.cadastrodeartigos.schemas.*;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserCreateResponse save(UserCreateRequest user);

    List<UserReadResponse> findAll();

    User findById(UUID id);

    User update(UserUpdateRequest userUpdate, UUID id);

    void delete(UUID id);
}
