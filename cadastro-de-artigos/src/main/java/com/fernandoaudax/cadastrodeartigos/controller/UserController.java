package com.fernandoaudax.cadastrodeartigos.controller;

import com.fernandoaudax.cadastrodeartigos.schemas.*;
import com.fernandoaudax.cadastrodeartigos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserReadResponse> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserReadResponse findById(@PathVariable(value = "id") UUID id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserCreateResponse save(@RequestBody UserCreateRequest user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public UserUpdateResponse update(@PathVariable(value = "id") UUID id, UserUpdateRequest user) {
        return userService.update(user, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") UUID id) {
        userService.delete(id);
    }
}
