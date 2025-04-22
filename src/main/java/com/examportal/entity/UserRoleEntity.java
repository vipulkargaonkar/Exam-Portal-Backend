package com.examportal.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "USER_ROLE")
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;

    //User
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;

    //Role
    @ManyToOne(fetch = FetchType.EAGER)
    private RolesEntity role;

    public UserRoleEntity() {
    }

    public UserRoleEntity(Long userRoleId, UserEntity user, RolesEntity role) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RolesEntity getRole() {
        return role;
    }

    public void setRole(RolesEntity role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleEntity that = (UserRoleEntity) o;
        return Objects.equals(userRoleId, that.userRoleId) && Objects.equals(user, that.user) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userRoleId, user, role);
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "userRoleId=" + userRoleId +
                ", user=" + user +
                ", role=" + role +
                '}';
    }
}
