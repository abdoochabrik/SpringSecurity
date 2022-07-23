package com.example1.demo.service;

import com.example1.demo.domain.AppUser;
import com.example1.demo.domain.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void AddRoleToUser(String username, String rolename);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
