package com.example.authservice.api;

import com.example.authservice.domain.AppUser;
import com.example.authservice.domain.Role;
import com.example.authservice.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @PostMapping("/user/save")
    public ResponseEntity<AppUser>saveUser(@RequestBody AppUser user){
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

    @PostMapping("/roles/save")
    public ResponseEntity<Role>saveRole( @RequestBody Role role ){
        return ResponseEntity.ok().body(userService.saveRole(role));
    }

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>>getUsers(){
        return ResponseEntity.ok().body(userService.getAppUsers());
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToAppUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }



}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
