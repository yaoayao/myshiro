package com.mytest.shiro.password;

import junit.framework.Assert;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.*;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Test;

import java.security.Key;


/**
 * Created by miyan(弥彦) on 2017/3/1 10:17.
 */
public class CodecAndCryptoTest {
    String str = "hello";
    String salt = "123";
    @Test
    public void testBase64(){
        String s = "hello";
        byte[] byteS = s.getBytes();
        String encodeS = Base64.encodeToString(byteS);
        String decodeS = Base64.decodeToString(encodeS);
        System.out.println("--------");
    }
    @Test
    public void testHex(){
        String s = "hello";
        String encodeS = Hex.encodeToString(s.getBytes());
        byte[] decodeS = Hex.decode(encodeS.toString());
        System.out.println("--------");
    }
    @Test
    public void testRandom(){
        SecureRandomNumberGenerator s = new SecureRandomNumberGenerator();
        s.setSeed("1234".getBytes());
        System.out.println(s.nextBytes().toHex());
    }
    @Test
    public void testMd5(){
        String str = "hello";
        String salt = "123";
        String md5 = new Md5Hash("b500f16cd48d9bb9664b973e597eb8ae").toString();
        System.out.println(md5);


        String algorithmName = "md5";
        String username = "liu";
        String password = "123";
        String salt1 = username;
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        int hashIterations = 2;

        SimpleHash hash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations);
        String encodedPassword = hash.toHex();
        System.out.println(encodedPassword);
    }
    @Test
    public void testSha1(){
        String sha1 = new Sha1Hash(str, salt).toString();
        System.out.println(sha1);
    }
    @Test
    public void testSha256(){
        String sha256 = new Sha256Hash(str , salt).toString();
        System.out.println(sha256);
    }
    @Test
    public void testHashService() {
        DefaultHashService hashService = new DefaultHashService(); //默认算法SHA-512
        hashService.setHashAlgorithmName("SHA-512");
        hashService.setPrivateSalt(new SimpleByteSource("123")); //私盐，默认无
        hashService.setGeneratePublicSalt(true);//是否生成公盐，默认false
        hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());//用于生成公盐。默认就这个
        hashService.setHashIterations(1); //生成Hash值的迭代次数

        HashRequest request = new HashRequest.Builder()
                .setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("hello"))
                .setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();
        String hex = hashService.computeHash(request).toHex();
        System.out.println(hex);
    }

    @Test
    public void testAesCipherService() {
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128);//设置key长度

        //生成key
        Key key = aesCipherService.generateNewKey();

        String text = "hello";

        //加密
        String encrptText = aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
        //解密
        String text2 = new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());
        System.out.println(key.getEncoded());
        System.out.println(encrptText);
        Assert.assertEquals(text, text2);
    }
}
