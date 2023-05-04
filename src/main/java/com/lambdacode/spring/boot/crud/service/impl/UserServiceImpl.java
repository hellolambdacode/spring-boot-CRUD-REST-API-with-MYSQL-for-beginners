package com.lambdacode.spring.boot.crud.service.impl;

import com.lambdacode.spring.boot.crud.dto.UserDTO;
import com.lambdacode.spring.boot.crud.entity.User;
import com.lambdacode.spring.boot.crud.repository.UserRepository;
import com.lambdacode.spring.boot.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * add user
     */
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    /**
     * get users as list
     */
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * get user by id
     */

    @Override
    public User getUser(Integer id) {
//        check weather the user is in database or not
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

        return user;
    }

    /**
     * update user
     */

    @Override
    public void updateUser(Integer id, User user) {
//        check weather the user is in database or not
        userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

        user.setId(id);

        userRepository.save(user);

    }

    @Override
    public void deleteUser(Integer id) {
//        check weather the user is in database or not
        User user = userRepository
                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

        userRepository.delete(user);
    }

    @Override
    public void updateName(Integer id, UserDTO userDTO) {
//        check weather the user is in database or not
        User user = userRepository
                .findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

        user.setName(userDTO.getName());

        userRepository.save(user);

    }
}
