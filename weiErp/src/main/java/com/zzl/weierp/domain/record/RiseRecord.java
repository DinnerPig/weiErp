package com.zzl.weierp.domain.record;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import com.zzl.weierp.domain.consumer.Consumer;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class RiseRecord {

    /**
     */
    @NotNull
    @ManyToOne
    private Consumer consumer;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date createDate;
}
