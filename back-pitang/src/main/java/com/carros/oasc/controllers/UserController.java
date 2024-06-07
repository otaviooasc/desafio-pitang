package com.carros.oasc.controllers;

import com.carros.oasc.dto.UserDTO;
import com.carros.oasc.dto.UserLoginDTO;
import com.carros.oasc.exceptions.UserException;
import com.carros.oasc.models.UserModel;
import com.carros.oasc.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok().body(userService.listUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        try{
            return ResponseEntity.ok().body(userService.findById(id));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDTO userDTO) {
        try {
            return ResponseEntity.ok().body(userService.saveUser(userDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<Object> login(@RequestBody @Valid UserLoginDTO userLoginDTO) {
        try {
            var user = userService.findByLogin(userLoginDTO.login());
            if (user != null) {
                if (user.getPassword().equals(userLoginDTO.password())) {
                    return ResponseEntity.status(HttpStatus.OK).body(user);
                }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid login or password.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid login or password.");
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<UserModel> changeUser(@PathVariable String id, @RequestBody UserDTO userDTO) throws UserException {
        return ResponseEntity.ok().body(userService.changeUser(id, userDTO));
    }
}
