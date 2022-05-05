package com.bezhan.spring.bootstrap.kata_bootstrap.service;

import com.bezhan.spring.bootstrap.kata_bootstrap.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
    void save(User user);
    void update(long id, User updatedUser);
    void delete(long id);
    User getUserByUsername(String username);
}