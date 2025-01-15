package com.sebas.curso.springboot.app.springbootcrud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.curso.springboot.app.springbootcrud.entities.Role;
import com.sebas.curso.springboot.app.springbootcrud.entities.User;
import com.sebas.curso.springboot.app.springbootcrud.repositories.RoleRepository;
import com.sebas.curso.springboot.app.springbootcrud.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();

        optionalRoleUser.ifPresent(role -> roles.add(role)); //.ifPresent(roles::add);
        
        if(user.isAdmin()){
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(roles::add); //.ifPresent(roles::add);
        }
        
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword().trim())); //Encriptado
        return userRepository.save(user);        
    }

}
