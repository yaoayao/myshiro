package com.mytest.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by miyan(弥彦) on 2017/2/28 14:39.
 */
public class MyRolePermissionResolver implements RolePermissionResolver {
    @Override
    public Collection<Permission> resolvePermissionsInRole(String s) {
        if ("role1".equals(s)){
            return Arrays.asList((Permission)new WildcardPermission("menu:*"));
        }
        return null;
    }
}
