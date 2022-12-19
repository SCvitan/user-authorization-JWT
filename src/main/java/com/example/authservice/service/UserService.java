package com.example.authservice.service;

import com.example.authservice.domain.AppUser;
import com.example.authservice.domain.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToAppUser(String username, String roleName);
    AppUser addAppUser(String username);
    List<AppUser>getAppUsers();
}
