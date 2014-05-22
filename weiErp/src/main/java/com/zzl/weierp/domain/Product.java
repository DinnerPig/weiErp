package com.zzl.weierp.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findProductsByType" })
public class Product {

    /**
     */
    private String name;

    /**
     */
    private String description;

    /**
     */
    private double price;

    /**
     */
    private String standard;

    /**
     */
    @ManyToOne
    private ProductType type;

    /**
     */
    private String serial;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<ProductImage> images = new HashSet<ProductImage>();

    /**
     */
    private String mainImage;

    /**
     */
    private double shareCash;
}
