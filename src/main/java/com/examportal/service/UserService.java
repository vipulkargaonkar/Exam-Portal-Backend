package com.examportal.service;

import com.examportal.entity.UserEntity;
import com.examportal.entity.UserRoleEntity;

import java.util.Set;

public interface UserService {

    public UserEntity createUser(UserEntity user, Set<UserRoleEntity> userRoles) throws Exception;

    public UserEntity getUser(String username);

    public void deleteUser(Long id);

    public UserEntity updateUser(UserEntity user);
}
