package com.zzl.weierp.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findProductOrdersByBusi" })
public class ProductOrder {

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    /**
     */
    private String serial;

    /**
     */
    private String address;

    /**
     */
    private String note;

    /**
     */
    @ManyToOne
    private Product product;

    /**
     */
    private int amount;

    /**
     */
    @ManyToOne
    private Busi busi;

    /**
     */
    private int status;

    /**
     */
    private int outAmount;
}
