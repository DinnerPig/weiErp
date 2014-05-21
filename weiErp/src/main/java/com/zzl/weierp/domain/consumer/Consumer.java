package com.zzl.weierp.domain.consumer;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findConsumersByUsernameEquals", "findConsumersByShareSerialEquals", "findConsumersBySerialEquals" })
public class Consumer {

    /**
     */
    @NotNull
    @Column(unique = true)
    private String username;

    /**
     */
    @NotNull
    private String password;

    /**
     */
    @NotNull
    private String shareSerial;

    /**
     */
    @NotNull
    private String serial;

    /**
     */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "consumer")
    private ConsumerBank bank;

    /**
     */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "consumer")
    private ConsumerDetail detail;

    /**
     * 等级�?普�?会员�?分享会员
     */
    @NotNull
    private int degree = 1;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date joinDate;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date createDate;
}
