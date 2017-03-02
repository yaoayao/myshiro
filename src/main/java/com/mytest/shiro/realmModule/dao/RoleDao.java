package com.mytest.shiro.realmModule.dao;

import com.mytest.shiro.realmModule.entity.Role;

/**
 * Created by miyan(弥彦) on 2017/3/2 10:17.
 */
public interface RoleDao {
    Role createRole(Role role);
    void deleteRole(Long roleId);
    void correlationPermissions(Long roleId , Long... permissionId);
    void uncorrelationPermissions(Long roleId , Long... permissionId);
    boolean exists(Long roleId , Long permissionId);

}
