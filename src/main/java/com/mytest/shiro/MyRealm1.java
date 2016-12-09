package com.mytest.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by yaoyao on 2016/12/8.
 */
public class MyRealm1 implements Realm {
    @Override
    public String getName() {
        return "myrealm1";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        if (!"wang".equals(name)){
            throw new UnknownAccountException();
        }
        if (!"123".equals(password)){
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(name, password, getName());
    }
}
