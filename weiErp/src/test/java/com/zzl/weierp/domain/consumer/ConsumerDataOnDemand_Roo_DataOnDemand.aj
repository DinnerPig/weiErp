// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.zzl.weierp.domain.consumer;

import com.zzl.weierp.domain.consumer.Consumer;
import com.zzl.weierp.domain.consumer.ConsumerBankDataOnDemand;
import com.zzl.weierp.domain.consumer.ConsumerDataOnDemand;
import com.zzl.weierp.domain.consumer.ConsumerDetailDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect ConsumerDataOnDemand_Roo_DataOnDemand {
    
    declare @type: ConsumerDataOnDemand: @Component;
    
    private Random ConsumerDataOnDemand.rnd = new SecureRandom();
    
    private List<Consumer> ConsumerDataOnDemand.data;
    
    @Autowired
    ConsumerBankDataOnDemand ConsumerDataOnDemand.consumerBankDataOnDemand;
    
    @Autowired
    ConsumerDetailDataOnDemand ConsumerDataOnDemand.consumerDetailDataOnDemand;
    
    public Consumer ConsumerDataOnDemand.getNewTransientConsumer(int index) {
        Consumer obj = new Consumer();
        setCreateDate(obj, index);
        setDegree(obj, index);
        setJoinDate(obj, index);
        setPassword(obj, index);
        setSerial(obj, index);
        setShareSerial(obj, index);
        setUsername(obj, index);
        return obj;
    }
    
    public void ConsumerDataOnDemand.setCreateDate(Consumer obj, int index) {
        Date createDate = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setCreateDate(createDate);
    }
    
    public void ConsumerDataOnDemand.setDegree(Consumer obj, int index) {
        int degree = 1;
        obj.setDegree(degree);
    }
    
    public void ConsumerDataOnDemand.setJoinDate(Consumer obj, int index) {
        Date joinDate = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setJoinDate(joinDate);
    }
    
    public void ConsumerDataOnDemand.setPassword(Consumer obj, int index) {
        String password = "password_" + index;
        obj.setPassword(password);
    }
    
    public void ConsumerDataOnDemand.setSerial(Consumer obj, int index) {
        String serial = "serial_" + index;
        obj.setSerial(serial);
    }
    
    public void ConsumerDataOnDemand.setShareSerial(Consumer obj, int index) {
        String shareSerial = "shareSerial_" + index;
        obj.setShareSerial(shareSerial);
    }
    
    public void ConsumerDataOnDemand.setUsername(Consumer obj, int index) {
        String username = "username_" + index;
        obj.setUsername(username);
    }
    
    public Consumer ConsumerDataOnDemand.getSpecificConsumer(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Consumer obj = data.get(index);
        Long id = obj.getId();
        return Consumer.findConsumer(id);
    }
    
    public Consumer ConsumerDataOnDemand.getRandomConsumer() {
        init();
        Consumer obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Consumer.findConsumer(id);
    }
    
    public boolean ConsumerDataOnDemand.modifyConsumer(Consumer obj) {
        return false;
    }
    
    public void ConsumerDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Consumer.findConsumerEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Consumer' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Consumer>();
        for (int i = 0; i < 10; i++) {
            Consumer obj = getNewTransientConsumer(i);
            try {
                obj.persist();
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}