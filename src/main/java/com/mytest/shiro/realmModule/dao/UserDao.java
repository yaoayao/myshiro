package com.mytest.shiro.realmModule.dao;

import com.mytest.shiro.realmModule.entity.User;

import java.util.Set;

/**
 * Created by miyan(弥彦) on 2017/3/2 10:37.
 */
public interface UserDao {
    User createUser(User user);
    void updateUser(User user);
    void deleteUser(Long userId);
    void correlationRoles(Long userId , Long... roleIds);
    void uncorrelationRoles(Long userId, Long... roleIds);
    boolean exists(Long userId , Long roleId);
    User findOne(Long userId);
    User findByUsername(String username);
    Set<String> findRoles(String username);
    Set<String> findPermissions(String name);
}
