package com.mytest.shiro.strategy;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.AbstractAuthenticationStrategy;
import org.apache.shiro.realm.Realm;

/**
 * Created by miyan(弥彦) on 2017/2/27 14:30.
 */
public class MyAuthenticatorStrategy extends AbstractAuthenticationStrategy {
    @Override
    public AuthenticationInfo beforeAttempt(Realm realm, AuthenticationToken token, AuthenticationInfo aggregate) throws AuthenticationException {
        System.out.println("MyAuthenticatorStrategy---");
        return super.beforeAttempt(realm, token, aggregate);
    }
}
