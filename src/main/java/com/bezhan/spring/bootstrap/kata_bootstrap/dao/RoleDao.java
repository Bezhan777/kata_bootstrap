package com.bezhan.spring.bootstrap.kata_bootstrap.dao;

import com.bezhan.spring.bootstrap.kata_bootstrap.entity.Role;

import java.util.Set;

public interface RoleDao {
    Set<Role> getAllRoles();
    Role getRoleById(int id);
    void save(Role role);
    void update(int id, Role updatedRole);
    void delete(int id);
    Role getRoleByName(String roleName);
}