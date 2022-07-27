package com.example1.demo.service;

import com.example1.demo.domain.AppUser;
import com.example1.demo.domain.Role;
import com.example1.demo.repo.RoleRepo;
import com.example1.demo.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j

public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepo appUserRepo;
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("saving new user to the database");
        return appUserRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void AddRoleToUser(String username, String rolename) {
       AppUser user = appUserRepo.findByUsername(username);
       Role role = roleRepo.findByName(rolename);
       user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return appUserRepo.findAll();
    }
}
