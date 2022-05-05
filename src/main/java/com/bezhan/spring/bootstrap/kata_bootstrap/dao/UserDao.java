package com.bezhan.spring.bootstrap.kata_bootstrap.dao;

import com.bezhan.spring.bootstrap.kata_bootstrap.entity.Role;
import com.bezhan.spring.bootstrap.kata_bootstrap.entity.User;

import java.util.List;

public interface UserDao {
        List<User> getAllUsers();
        User getUserById(long id);
        void save(User user);
        void update(long id, User updatedUser);
        void delete(long id);

        User getUserByUsername(String username);

        void addRoleToUser(User user, Role role);

}