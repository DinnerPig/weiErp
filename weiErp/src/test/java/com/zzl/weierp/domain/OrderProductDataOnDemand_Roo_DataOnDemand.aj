// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.zzl.weierp.domain;

import com.zzl.weierp.domain.OrderProduct;
import com.zzl.weierp.domain.OrderProductDataOnDemand;
import com.zzl.weierp.domain.ProductDataOnDemand;
import com.zzl.weierp.domain.ProductOrderDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect OrderProductDataOnDemand_Roo_DataOnDemand {
    
    declare @type: OrderProductDataOnDemand: @Component;
    
    private Random OrderProductDataOnDemand.rnd = new SecureRandom();
    
    private List<OrderProduct> OrderProductDataOnDemand.data;
    
    @Autowired
    ProductDataOnDemand OrderProductDataOnDemand.productDataOnDemand;
    
    @Autowired
    ProductOrderDataOnDemand OrderProductDataOnDemand.productOrderDataOnDemand;
    
    public OrderProduct OrderProductDataOnDemand.getNewTransientOrderProduct(int index) {
        OrderProduct obj = new OrderProduct();
        setAmount(obj, index);
        setOutAmount(obj, index);
        setPrice(obj, index);
        return obj;
    }
    
    public void OrderProductDataOnDemand.setAmount(OrderProduct obj, int index) {
        int amount = index;
        obj.setAmount(amount);
    }
    
    public void OrderProductDataOnDemand.setOutAmount(OrderProduct obj, int index) {
        int outAmount = index;
        obj.setOutAmount(outAmount);
    }
    
    public void OrderProductDataOnDemand.setPrice(OrderProduct obj, int index) {
        double price = new Integer(index).doubleValue();
        obj.setPrice(price);
    }
    
    public OrderProduct OrderProductDataOnDemand.getSpecificOrderProduct(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        OrderProduct obj = data.get(index);
        Long id = obj.getId();
        return OrderProduct.findOrderProduct(id);
    }
    
    public OrderProduct OrderProductDataOnDemand.getRandomOrderProduct() {
        init();
        OrderProduct obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return OrderProduct.findOrderProduct(id);
    }
    
    public boolean OrderProductDataOnDemand.modifyOrderProduct(OrderProduct obj) {
        return false;
    }
    
    public void OrderProductDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = OrderProduct.findOrderProductEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'OrderProduct' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<OrderProduct>();
        for (int i = 0; i < 10; i++) {
            OrderProduct obj = getNewTransientOrderProduct(i);
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
