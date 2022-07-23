package com.example1.demo.service;

import com.example1.demo.domain.AppUser;
import com.example1.demo.domain.Role;

import java.util.List;

public class UserServiceImplementation implements UserService{
    @Override
    public AppUser saveUser(AppUser user) {
        return null;
    }

    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public void AddRoleToUser(String username, String rolename) {

    }

    @Override
    public AppUser getUser(String username) {
        return null;
    }

    @Override
    public List<AppUser> getUsers() {
        return null;
    }
}
