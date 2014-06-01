package com.zzl.weierp.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class OrderProduct {

    /**
     */
    @OneToOne
    private Product product;

    /**
     */
    private int amount;

    /**
     */
    private int outAmount;

    /**
     */
    @ManyToOne
    private ProductOrder productOrder;

    /**
     */
    @NotNull
    private double price;
}
