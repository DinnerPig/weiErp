package com.zzl.weierp.domain.manager;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findManagersBySerialEquals" })
public class Manager {

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
    private String serial;
}
