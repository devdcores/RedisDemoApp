package com.devd.redis.redisdemo.service;

import com.devd.redis.redisdemo.dao.UserDao;
import com.devd.redis.redisdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public void saveUserAsString(String userId, User userInfo) {
        userDao.saveUserAsString(userId,userInfo);
    }

    @Override
    public User getUserAsString(String userId) {
        return userDao.getUserAsString(userId);
    }

    @Override
    public void addToUserList(User user) {
        userDao.addToUserList(user);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public void saveUserToHash(User user) {
        userDao.saveUserToHash(user);
    }

    @Override
    public void updateUserInHash(User user) {
        userDao.updateUserInHash(user);
    }
    @Override
    public Map<Long, User> getAllUsersFromHash() {
        return userDao.getAllUsersFromHash();
    }

    @Override
    public User getUserFromHash(Long userId) {
        return userDao.getUserFromHash(userId);
    }

    @Override
    public void deleteUserInHash(Long userId) {
        userDao.deleteUserInHash(userId);
    }
}
