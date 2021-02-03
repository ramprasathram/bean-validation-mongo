package com.example.beanvalidationmongo.controller;

import com.example.beanvalidationmongo.document.Users;
import com.example.beanvalidationmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/getUser/{id}")
    public Optional<Users> getUserById(@PathVariable int id) {
        return userRepository.findById(id);
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUsers(@RequestBody @Valid Users users) {
        System.out.println("Inside Add");
        userRepository.save(users);
        return ResponseEntity.ok("User data is valid");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }
}
