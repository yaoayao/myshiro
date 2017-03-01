package com.mytest.shiro.password;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by miyan(弥彦) on 2017/3/1 11:36.
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Ehcache retryLimitCache;

    public RetryLimitHashedCredentialsMatcher() {
        CacheManager cacheManager = CacheManager.newInstance(CacheManager.class.getClassLoader().getResource("ehcache.xml"));
        retryLimitCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String userName = (String)token.getPrincipal();
        Element element = retryLimitCache.get(userName);
        if (element == null){
            element = new Element(userName ,new AtomicInteger(0));
            retryLimitCache.put(element);
        }
        AtomicInteger time = (AtomicInteger)element.getObjectValue();
        if (time.incrementAndGet() > 3){
            throw new ExcessiveAttemptsException();
        }

        boolean match = super.doCredentialsMatch(token, info);
        if (match){
            retryLimitCache.remove(userName);
        }
        return match;
    }
}
