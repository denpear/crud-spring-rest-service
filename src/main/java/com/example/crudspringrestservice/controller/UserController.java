package com.example.crudspringrestservice.controller;

import com.example.crudspringrestservice.dto.UserEntityDTO;
import com.example.crudspringrestservice.manager.CrudManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    private final CrudManager<UserEntityDTO> crudManager;

    @Autowired
    public UserController(CrudManager<UserEntityDTO> crudManager) {
        this.crudManager = crudManager;
    }

    @GetMapping(value = "/users/{id}")
    public UserEntityDTO findUserById(@PathVariable Long id){
        return crudManager.read(id);
    }

    @PostMapping (value = "/users/")
    public UserEntityDTO createUser(@RequestBody UserEntityDTO userEntityDTO){
        return crudManager.create(userEntityDTO);
    }

    @PatchMapping (value = "/users/")
    public UserEntityDTO updateUser (@RequestBody UserEntityDTO userEntityDTO){
        return crudManager.update(userEntityDTO);
    }

    @DeleteMapping (value = "/users/{id}")
    public void deleteUserById(@PathVariable Long id){
         crudManager.delete(id);
    }
}


