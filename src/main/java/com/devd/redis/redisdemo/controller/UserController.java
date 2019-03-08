package com.devd.redis.redisdemo.controller;

import com.devd.redis.redisdemo.model.User;
import com.devd.redis.redisdemo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(value = "/user")
    public void addUser(@RequestBody User user) {
        userService.saveUserAsString(String.valueOf(user.getUserId()), user);
    }

    @GetMapping(path = "/user/{userId}", produces = "application/json")
    public User getUser(@PathVariable String userId) {
        return userService.getUserAsString(userId);
    }

    @PostMapping(value = "/user/list")
    public void addUserToList(@RequestBody User user) {
        userService.addToUserList(user);
    }

    @GetMapping(path = "/user/list", produces = "application/json")
    public List<User> getUser() {
        return userService.getUserList();
    }

    @PostMapping(value = "/user/hash")
    void addUserToHash(@RequestBody User user){
        userService.saveUserToHash(user);
    }

    @PutMapping(value = "/user/hash")
    void updateUserInHash(@RequestBody User user){
        userService.updateUserInHash(user);
    }

    @GetMapping(path = "/user/hash/{userId}", produces = "application/json")
    public User getUserFromHash(@PathVariable Long userId) {
        return userService.getUserFromHash(userId);
    }

    @GetMapping(path = "/user/hash", produces = "application/json")
    public Map<Long, User> getAllUsersFromHash() {
        return userService.getAllUsersFromHash();
    }
    @DeleteMapping(path = "/user/hash/{userId}")
    public void deleteUserInHash(@PathVariable Long userId) {
        userService.deleteUserInHash(userId);
    }

}
