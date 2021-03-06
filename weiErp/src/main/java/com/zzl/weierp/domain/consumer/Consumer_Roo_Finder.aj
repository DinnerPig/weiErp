// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.zzl.weierp.domain.consumer;

import com.zzl.weierp.domain.consumer.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect Consumer_Roo_Finder {
    
    public static TypedQuery<Consumer> Consumer.findConsumersBySerialEquals(String serial) {
        if (serial == null || serial.length() == 0) throw new IllegalArgumentException("The serial argument is required");
        EntityManager em = Consumer.entityManager();
        TypedQuery<Consumer> q = em.createQuery("SELECT o FROM Consumer AS o WHERE o.serial = :serial", Consumer.class);
        q.setParameter("serial", serial);
        return q;
    }
    
    public static TypedQuery<Consumer> Consumer.findConsumersByShareSerialEquals(String shareSerial) {
        if (shareSerial == null || shareSerial.length() == 0) throw new IllegalArgumentException("The shareSerial argument is required");
        EntityManager em = Consumer.entityManager();
        TypedQuery<Consumer> q = em.createQuery("SELECT o FROM Consumer AS o WHERE o.shareSerial = :shareSerial", Consumer.class);
        q.setParameter("shareSerial", shareSerial);
        return q;
    }
    
    public static TypedQuery<Consumer> Consumer.findConsumersByUsernameEquals(String username) {
        if (username == null || username.length() == 0) throw new IllegalArgumentException("The username argument is required");
        EntityManager em = Consumer.entityManager();
        TypedQuery<Consumer> q = em.createQuery("SELECT o FROM Consumer AS o WHERE o.username = :username", Consumer.class);
        q.setParameter("username", username);
        return q;
    }
    
}
