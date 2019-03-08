package com.devd.redis.redisdemo.dao;

import com.devd.redis.redisdemo.model.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    void saveUserAsString(String userId, User userInfo);

    User getUserAsString(String userId);

    void addToUserList(User user);

    List<User> getUserList();

    void saveUserToHash(User user);

    void updateUserInHash(User user);

    Map<Long, User> getAllUsersFromHash();

    User getUserFromHash(Long userId);

    void deleteUserInHash(Long userId);

}
