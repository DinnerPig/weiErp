package com.zzl.weierp.domain.consumer;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.OneToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ConsumerDetail {

    /**
     */
    @NotNull
    private String phone;

    /**
     */
    @NotNull
    private String trueName;

    /**
     */
    @NotNull
    private String address;

    /**
     */
    private String qq;

    /**
     */
    private String email;

    /**
     */
    @OneToOne
    private Consumer consumer;
}
