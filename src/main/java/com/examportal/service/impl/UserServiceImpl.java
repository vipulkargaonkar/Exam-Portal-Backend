package com.examportal.service.impl;

import com.examportal.entity.UserEntity;
import com.examportal.entity.UserRoleEntity;
import com.examportal.repository.RolesRepository;
import com.examportal.repository.UserRepository;
import com.examportal.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.Objects.nonNull;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;

    public UserServiceImpl(UserRepository userRepository, RolesRepository rolesRepository) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public UserEntity createUser(UserEntity user, Set<UserRoleEntity> userRoles) throws Exception {
        UserEntity dbUser = getUser(user.getUserName());

        if (nonNull(dbUser))
            throw new Exception("User already present");

        for (UserRoleEntity userRole : userRoles)
            rolesRepository.save(userRole.getRole());

        user.getUserRoles().addAll(userRoles);

        dbUser = userRepository.save(user);

        return dbUser;
    }

    @Override
    public UserEntity getUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        return userRepository.save(user);
    }
}
