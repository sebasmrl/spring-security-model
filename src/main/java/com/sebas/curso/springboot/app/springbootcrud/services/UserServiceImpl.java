package com.sebas.curso.springboot.app.springbootcrud.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sebas.curso.springboot.app.springbootcrud.entities.User;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User save(User user) {
        return null;        
    }

}
