package com.example1.demo.service;

import com.example1.demo.domain.AppUser;
import com.example1.demo.domain.Role;
import com.example1.demo.repo.RoleRepo;
import com.example1.demo.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j

public class UserServiceImplementation implements UserService, UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepo.findByUsername(username);
        if(user == null){
           log.error("User not found in the db");
           throw new UsernameNotFoundException("User not found in the db");
        }
        else {
            log.info("User  found in the db");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities);
    }
}
