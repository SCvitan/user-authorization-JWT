package com.example.authservice.service;

import com.example.authservice.domain.AppUser;
import com.example.authservice.domain.Role;
import com.example.authservice.repo.RoleRepo;
import com.example.authservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImplementation implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public AppUser saveUser(AppUser user) {
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToAppUser(String username, String roleName) {
        AppUser user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public AppUser addAppUser(String username) {
        return userRepo.findByUsername(username);
    }


    //FYI => it is a bad practice to return everything from database
    @Override
    public List<AppUser> getAppUsers() {
        return userRepo.findAll();
    }
}
