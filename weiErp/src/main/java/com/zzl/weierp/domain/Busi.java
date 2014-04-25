package com.zzl.weierp.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findBusisByUsernameEquals" })
public class Busi {

    /**
     */
    private String username;

    /**
     */
    private String password;

    /**
     */
    private String realname;

    /**
     */
    private String phone;

    /**
     */
    private String qq;

    /**
     */
    private String weixin;

    /**
     */
    private String address;

    /**
     */
    private String serial;
}
