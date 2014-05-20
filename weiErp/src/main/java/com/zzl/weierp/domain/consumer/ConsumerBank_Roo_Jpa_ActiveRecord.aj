// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.zzl.weierp.domain.consumer;

import com.zzl.weierp.domain.consumer.ConsumerBank;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ConsumerBank_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager ConsumerBank.entityManager;
    
    public static final EntityManager ConsumerBank.entityManager() {
        EntityManager em = new ConsumerBank().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long ConsumerBank.countConsumerBanks() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ConsumerBank o", Long.class).getSingleResult();
    }
    
    public static List<ConsumerBank> ConsumerBank.findAllConsumerBanks() {
        return entityManager().createQuery("SELECT o FROM ConsumerBank o", ConsumerBank.class).getResultList();
    }
    
    public static ConsumerBank ConsumerBank.findConsumerBank(Long id) {
        if (id == null) return null;
        return entityManager().find(ConsumerBank.class, id);
    }
    
    public static List<ConsumerBank> ConsumerBank.findConsumerBankEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ConsumerBank o", ConsumerBank.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void ConsumerBank.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void ConsumerBank.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            ConsumerBank attached = ConsumerBank.findConsumerBank(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void ConsumerBank.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void ConsumerBank.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public ConsumerBank ConsumerBank.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ConsumerBank merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
