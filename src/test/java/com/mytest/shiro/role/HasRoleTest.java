package com.mytest.shiro.role;

import com.mytest.shiro.MyTestShiro;
import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by miyan(弥彦) on 2017/2/28 10:03.
 */
public class HasRoleTest {
    @Test
    public void testRole() {
        MyTestShiro.login("classpath:shiro-role.ini");
        Subject subject = SecurityUtils.getSubject();
        Assert.assertTrue(subject.hasRole("role3"));
        Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1","role3")));
    }
    @Test
    public void testPermitted(){
        MyTestShiro.login("classpath:shiro-role.ini");
        Subject subject = SecurityUtils.getSubject();
        Assert.assertTrue(subject.isPermitted("user:create"));
        Assert.assertTrue(subject.isPermitted("user:update"));
    }
}
