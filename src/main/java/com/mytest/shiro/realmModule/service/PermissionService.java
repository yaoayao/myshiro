package com.mytest.shiro.realmModule.service;

import com.mytest.shiro.realmModule.entity.Permission;

/**
 * Created by miyan(弥彦) on 2017/3/2 15:13.
 */
public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
