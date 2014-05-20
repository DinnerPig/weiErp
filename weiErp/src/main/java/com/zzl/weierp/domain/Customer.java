package com.zzl.weierp.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Customer {

    /**
     */
    private String username;

    /**
     */
    private String password;

    /**
     */
    private String nickname;

    /**
     */
    private String phone;

    /**
     */
    private String qq;
}
