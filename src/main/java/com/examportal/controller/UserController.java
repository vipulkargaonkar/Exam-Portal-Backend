package com.examportal.controller;

import com.examportal.entity.RolesEntity;
import com.examportal.entity.UserEntity;
import com.examportal.entity.UserRoleEntity;
import com.examportal.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity user) throws Exception {
        user.setProfile("DEFAULT");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRoleEntity> roles = new HashSet<>();

        RolesEntity role = new RolesEntity();
        role.setRoleId(2L);
        role.setRoleName("NORMAL");

        UserRoleEntity userRole = new UserRoleEntity();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return userService.createUser(user, roles);
    }

    @GetMapping("/{username}")
    public UserEntity getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/update")
    public UserEntity updateUser(@RequestBody UserEntity user) {
        return userService.updateUser(user);
    }

}
