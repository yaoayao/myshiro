package com.mytest.shiro.realmModule.service;

import com.mytest.shiro.realmModule.entity.Role;

/**
 * Created by miyan(弥彦) on 2017/3/2 15:16.
 */
public interface RoleService {
    public Role createRole(Role role);
    public void deleteRole(Long roleId);

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void correlationPermissions(Long roleId, Long... permissionIds);

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
