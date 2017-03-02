package com.mytest.shiro.realmModule.dao;

import com.mytest.shiro.realmModule.entity.Permission;

/**
 * Created by miyan(弥彦) on 2017/3/2 10:01.
 */
public interface PermissionDao {
    Permission createPermission(Permission permission);
    void deletePermission(Long permissionId);
}
