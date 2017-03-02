package com.mytest.shiro.realmModule.service;

import com.mytest.shiro.realmModule.entity.User;

import java.util.Set;

/**
 * Created by miyan(弥彦) on 2017/3/2 14:56.
 */
public interface UserService {
    public User createUser(User user);
    public void changePassword(Long userId, String newPassword);
    public void correlationRoles(Long userId, Long... roleIds);
    public void uncorrelationRoles(Long userId, Long... roleIds);
    public User findByUsername(String username);
    public Set<String> findRoles(String username);
    public Set<String> findPermissions(String username);
}
