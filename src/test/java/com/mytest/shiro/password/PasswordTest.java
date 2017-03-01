package com.mytest.shiro.password;

import com.mytest.shiro.BaseTest;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.AbstractConverter;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.junit.Test;

/**
 * Created by miyan(弥彦) on 2017/2/28 17:19.
 */
public class PasswordTest extends BaseTest{
    @Test
    public void testPassword(){
        login("classpath:shiro-password-service.ini","wu","123");
        Object principal = getSubject().getPrincipal();
        System.out.println("---------");
    }
    @Test
    public void testJdbcPassword(){
        login("classpath:shiro-jdbc-password.ini","wu","123");

    }
    @Test
    public void testHashedCredentialsMatcherWithMyRealm2() {
        //使用testGeneratePassword生成的散列密码
        for (int i = 0; i <5 ; i++)
            login("classpath:shiro-retry.ini", "liu", "1231");
    }
    @Test
    public void testHashedCredentialsMatcherWithJdbcRealm() {

        BeanUtilsBean.getInstance().getConvertUtils().register(new EnumConverter(), JdbcRealm.SaltStyle.class);

        //使用testGeneratePassword生成的散列密码
        login("classpath:shiro-jdbc-hashedCredentialsMatcher.ini", "liu", "123");
    }


    private class EnumConverter extends AbstractConverter {
        @Override
        protected String convertToString(final Object value) throws Throwable {
            return ((Enum) value).name();
        }
        @Override
        protected Object convertToType(final Class type, final Object value) throws Throwable {
            return Enum.valueOf(type, value.toString());
        }

        @Override
        protected Class getDefaultType() {
            return null;
        }

    }
    @Test
    public void test(){
        String algorithmName = "md5";
        String username = "liu";
        String password = "123";
        String salt1 = username;
        String salt2 = "24520ee264eab73ec09451d0e9ea6aac";
        int hashIterations = 2;
        System.out.println(new Md5Hash(new Md5Hash("123liu24520ee264eab73ec09451d0e9ea6aac")));

        SimpleHash hash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations);
        String encodedPassword = hash.toHex();
        System.out.println(encodedPassword);
    }
}
