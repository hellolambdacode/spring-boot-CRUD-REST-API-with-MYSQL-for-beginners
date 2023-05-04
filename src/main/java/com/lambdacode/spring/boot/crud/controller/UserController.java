package com.lambdacode.spring.boot.crud.controller;

import com.lambdacode.spring.boot.crud.dto.UserDTO;
import com.lambdacode.spring.boot.crud.entity.User;
import com.lambdacode.spring.boot.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * add user
     */

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);

        return "success add user";
    }

    /**
     * get users as list
     */

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    /**
     * get user by id
     */

    @GetMapping("/get")
    public User getUser(@RequestParam Integer id) {
        return userService.getUser(id);
    }

    /**
     * update user
     */

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.updateUser(id, user);

        return ResponseEntity.noContent().build();
    }

    /**
     * delete user
     */

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * update name
     */

    @PatchMapping("/update-name/{id}")
    public ResponseEntity<Void> updateName(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        userService.updateName(id, userDTO);

        return ResponseEntity.noContent().build();
    }

}
