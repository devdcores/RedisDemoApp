package com.devd.redis.redisdemo.dao;

import com.devd.redis.redisdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Repository
public class UserDaoImpl implements UserDao {

    public static final String REDIS_USER_LIST = "UserList";
    public static final String REDIS_USER_HASH = "UserHash";


    @Autowired
    RedisTemplate<String, User> redisTemplate;

    @Autowired
    ListOperations<String, User> listRedisTemplate;

    @Autowired
    HashOperations<String, Long, User> mapRedisTemplate;

    @Override
    public void saveUserAsString(String userId, User userInfo) {
        redisTemplate.opsForValue().set(userId, userInfo);
        redisTemplate.expire(userId, 10, TimeUnit.SECONDS);
    }

    @Override
    public User getUserAsString(String userId) {
        return redisTemplate.opsForValue().get(userId);
    }

    @Override
    public void addToUserList(User user) {
        listRedisTemplate.leftPush(REDIS_USER_LIST, user);
    }

    @Override
    public List<User> getUserList() {
        return listRedisTemplate.range(REDIS_USER_LIST, 0, -1);
    }

    @Override
    public void saveUserToHash(User user) {
        mapRedisTemplate.put(REDIS_USER_HASH, user.getUserId(), user);
    }

    @Override
    public void updateUserInHash(User user) {
        mapRedisTemplate.put(REDIS_USER_HASH, user.getUserId(), user);
    }

    @Override
    public Map<Long, User> getAllUsersFromHash() {
        return mapRedisTemplate.entries(REDIS_USER_HASH);
    }

    @Override
    public User getUserFromHash(Long userId) {
        return mapRedisTemplate.get(REDIS_USER_HASH, userId);
    }

    @Override
    public void deleteUserInHash(Long userId) {
        mapRedisTemplate.delete(REDIS_USER_HASH, userId);
    }
}
