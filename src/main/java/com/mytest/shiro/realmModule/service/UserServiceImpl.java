package com.mytest.shiro.realmModule.service;

import com.mytest.shiro.realmModule.dao.UserDao;
import com.mytest.shiro.realmModule.dao.UserDaoImpl;
import com.mytest.shiro.realmModule.entity.User;

import java.util.Set;

/**
 * Created by miyan(弥彦) on 2017/3/2 15:07.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    private PasswordHelper passwordHelper = new PasswordHelper();
    @Override
    public User createUser(User user) {
        passwordHelper.encryptPassword(user);
        return userDao.createUser(user);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        User user =userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {
        userDao.correlationRoles(userId, roleIds);
    }

    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {
        userDao.uncorrelationRoles(userId , roleIds);
    }

    @Override
    public User findByUsername(String username) {
        User byUsername = userDao.findByUsername(username);
        return byUsername;
    }

    @Override
    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }

    @Override
    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }
}
