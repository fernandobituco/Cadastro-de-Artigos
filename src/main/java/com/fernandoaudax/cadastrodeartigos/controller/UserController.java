package com.fernandoaudax.cadastrodeartigos.controller;

import com.fernandoaudax.cadastrodeartigos.ExceptionHandlers.MultipleErrorResponse;
import com.fernandoaudax.cadastrodeartigos.ExceptionHandlers.UserNotFoundException;
import com.fernandoaudax.cadastrodeartigos.schemas.*;
import com.fernandoaudax.cadastrodeartigos.service.UserService;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{userUuid}")
    public ResponseEntity<Object> findById(@PathVariable(value = "userUuid") UUID userUuiid) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new UserReadResponse(userService.findById(userUuiid)));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new SingleValidation(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody UserCreateRequest user) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
        } catch (Throwable e) {
            MultipleErrorResponse error = new MultipleErrorResponse("Check input", e);
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PutMapping("/{userUuid}")
    public ResponseEntity<Object> update(@PathVariable(value = "userUuid") UUID userUuiid, UserUpdateRequest user) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new UserUpdateResponse(userService.update(user, userUuiid)));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Throwable e) {
            MultipleErrorResponse error = new MultipleErrorResponse("Check input", e);
            return ResponseEntity.badRequest().body(error);
        }
    }

    @DeleteMapping("/{userUuid}")
    public ResponseEntity<Object> delete(@PathVariable(value = "userUuid") UUID userUuiid) {
        try {
            userService.delete(userUuiid);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
