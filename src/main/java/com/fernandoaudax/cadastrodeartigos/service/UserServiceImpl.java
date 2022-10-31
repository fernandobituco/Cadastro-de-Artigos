package com.fernandoaudax.cadastrodeartigos.service;

import com.fernandoaudax.cadastrodeartigos.ExceptionHandlers.UserNotFoundException;
import com.fernandoaudax.cadastrodeartigos.entity.User;
import com.fernandoaudax.cadastrodeartigos.repository.UserRepository;
import com.fernandoaudax.cadastrodeartigos.schemas.*;
import org.hibernate.TypeMismatchException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService{
    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserCreateResponse save(UserCreateRequest user) {
        User saveUser = new User(user);
        userRepository.save(saveUser);
        return new UserCreateResponse(saveUser);
    }

    @Override
    public List<UserReadResponse> findAll() {
        return userRepository.findAll().stream().map(UserReadResponse::new).collect(Collectors.toList());
    }

    @Transactional
    public User findById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        return user.get();
    }

    @Transactional
    public User update(UserUpdateRequest userUpdate, UUID id) {
        User user = findById(id);
        user.setUsername(userUpdate.getUsername());
        user.setPassword(user.getPassword());
        return user;
    }

    @Transactional
    public void delete(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException();
        } else {
            userRepository.deleteById(id);
        }
    }
}
