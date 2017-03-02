package com.mytest.shiro.realmModule.service;

import com.mytest.shiro.realmModule.dao.PermissionDao;
import com.mytest.shiro.realmModule.dao.PermissionDaoImpl;
import com.mytest.shiro.realmModule.entity.Permission;

/**
 * Created by miyan(弥彦) on 2017/3/2 15:14.
 */
public class PermissionServiceImpl implements PermissionService {
    private PermissionDao permissionDao = new PermissionDaoImpl();
    @Override
    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    @Override
    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
