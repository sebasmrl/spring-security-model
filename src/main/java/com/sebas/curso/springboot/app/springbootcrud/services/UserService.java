package com.sebas.curso.springboot.app.springbootcrud.services;

import java.util.List;

import com.sebas.curso.springboot.app.springbootcrud.entities.User;

public interface UserService {
    List<User> findAll();
    User save(User user);
}
