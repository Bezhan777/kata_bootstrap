package com.bezhan.spring.bootstrap.kata_bootstrap.util;

import com.bezhan.spring.bootstrap.kata_bootstrap.entity.Role;
import com.bezhan.spring.bootstrap.kata_bootstrap.entity.User;
import com.bezhan.spring.bootstrap.kata_bootstrap.service.RoleService;
import com.bezhan.spring.bootstrap.kata_bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DBInit {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PostConstruct
    public void createUsersWithRoles() {
        Role role1 = new Role("ADMIN");
        Role role2 = new Role("USER");

        roleService.save(role1);
        roleService.save(role2);

        User user1 = new User("ivan", "ivanov", 35, "ivan@email.com");
        User user2 = new User("maxim", "maximov", 28, "maksim@email.com");
        User user3 = new User("anton", "antonov", 37, "anton@email.com");
        User user4 = new User("kirill", "kirilov", 32, "kiril@email.com");
        User user5 = new User("petr", "petrov", 29, "petr@email.com");

        user1.setRoles(new HashSet<>(Set.of(role1,role2)));
        user2.setRoles(new HashSet<>(Set.of(role1)));
        user3.setRoles(new HashSet<>(Set.of(role2)));

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        System.out.println("privet"+ user1);
    }
}