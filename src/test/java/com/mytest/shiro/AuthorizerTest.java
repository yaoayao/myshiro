package com.mytest.shiro;

import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Created by miyan(弥彦) on 2017/2/28 14:52.
 */
public class AuthorizerTest {

    @Test
    public void test(){
        MyTestShiro.login("classpath:shiro-authorizer.ini");
        Subject subject = SecurityUtils.getSubject();
        //判断拥有权限：user:create
//        Assert.assertTrue(subject.isPermitted("user1:update"));
//        Assert.assertTrue(subject.isPermitted("user2:update"));
//        //通过二进制位的方式表示权限
//        Assert.assertTrue(subject.isPermitted("+user1+2"));//新增权限
//        Assert.assertTrue(subject.isPermitted("+user1+8"));//查看权限
//        Assert.assertTrue(subject.isPermitted("+user2+10"));//新增及查看
//
//        Assert.assertFalse(subject.isPermitted("+user1+4"));//没有删除权限
//
        Assert.assertTrue(subject.isPermitted("menu:view"));//通过MyRolePermissionResolver解析得到的权限
    }
    @Test
    public void testCommon(){
        System.out.println(2&10);
    }
}
