// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.zzl.weierp.domain.manager;

import com.zzl.weierp.domain.manager.Manager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Manager_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Manager.entityManager;
    
    public static final EntityManager Manager.entityManager() {
        EntityManager em = new Manager().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Manager.countManagers() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Manager o", Long.class).getSingleResult();
    }
    
    public static List<Manager> Manager.findAllManagers() {
        return entityManager().createQuery("SELECT o FROM Manager o", Manager.class).getResultList();
    }
    
    public static Manager Manager.findManager(Long id) {
        if (id == null) return null;
        return entityManager().find(Manager.class, id);
    }
    
    public static List<Manager> Manager.findManagerEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Manager o", Manager.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Manager.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Manager.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Manager attached = Manager.findManager(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Manager.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Manager.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Manager Manager.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Manager merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
