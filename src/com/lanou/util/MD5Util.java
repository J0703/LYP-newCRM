package com.lanou.util;

import org.junit.Test;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by dllo on 17/10/30.
 */
@Component
public class MD5Util {


    /**利用MD5进行加密
     * @param str 待加密的字符串
     * @return 加密后的字符串
     * @throws NoSuchAlgorithmException 没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException
     */
    public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));

//        System.out.println(newstr);

        return newstr;

    }

    /**判断用户密码是否正确
     * @param newpasswd 用户输入的密码
     * @param oldpasswd 数据库中存储的密码－－用户密码的摘要
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public boolean checkpassword(String newpasswd,String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        if(EncoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }



    @Test
    public void a() throws NoSuchAlgorithmException, UnsupportedEncodingException{

        String newpasswd = "0123456";
        String oldpasswd = "EkvRKWvsDZ2Tx7Uqca2NWw==";

        System.out.println(EncoderByMd5(newpasswd).equals(oldpasswd));
    }



    @Test
    public void JM() {

        String inStr = "ttdn0vjtXSGkSw5YhmgMuQ==";

        char [] a = inStr.toCharArray();
        for  ( int  i =  0 ; i < a.length; i++) {
            a[i] = (char ) (a[i] ^  't' );
        }
        String k = new  String(a);

        System.out.println(k);

    }


}
