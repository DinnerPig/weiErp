package com.zzl.weierp.domain.consumer;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.OneToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ConsumerBank {

    /**
     */
    private String payAccount;

    /**
     */
    private String bank;

    /**
     */
    private String bankAccount;

    /**
     */
    private String bankUser;

    /**
     */
    @OneToOne
    private Consumer consumer;
}
