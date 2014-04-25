// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.zzl.weierp.domain;

import com.zzl.weierp.domain.ProductImage;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ProductImage_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager ProductImage.entityManager;
    
    public static final EntityManager ProductImage.entityManager() {
        EntityManager em = new ProductImage().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long ProductImage.countProductImages() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductImage o", Long.class).getSingleResult();
    }
    
    public static List<ProductImage> ProductImage.findAllProductImages() {
        return entityManager().createQuery("SELECT o FROM ProductImage o", ProductImage.class).getResultList();
    }
    
    public static ProductImage ProductImage.findProductImage(Long id) {
        if (id == null) return null;
        return entityManager().find(ProductImage.class, id);
    }
    
    public static List<ProductImage> ProductImage.findProductImageEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductImage o", ProductImage.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void ProductImage.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void ProductImage.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            ProductImage attached = ProductImage.findProductImage(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void ProductImage.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void ProductImage.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public ProductImage ProductImage.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductImage merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
