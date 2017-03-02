package com.mytest.shiro.realmModule.service;

import com.mytest.shiro.realmModule.dao.RoleDao;
import com.mytest.shiro.realmModule.dao.RoleDaoImpl;
import com.mytest.shiro.realmModule.entity.Role;

/**
 * Created by miyan(弥彦) on 2017/3/2 15:17.
 */
public class RoleServiceImpl implements  RoleService{
    private RoleDao roleDao = new RoleDaoImpl();


    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        roleDao.correlationPermissions(roleId, permissionIds);
    }

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        roleDao.uncorrelationPermissions(roleId, permissionIds);
    }
}
