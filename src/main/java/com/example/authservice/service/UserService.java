package com.example.authservice.service;

import com.example.authservice.domain.AppUser;
import com.example.authservice.domain.Role;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
}
