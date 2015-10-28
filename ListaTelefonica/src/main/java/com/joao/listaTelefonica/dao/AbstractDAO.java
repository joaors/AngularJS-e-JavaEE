/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joao.listaTelefonica.dao;

import com.joao.listaTelefonica.model.Entidade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author joao
 * @param <T>
 */
public abstract class AbstractDAO<T extends Entidade> {
   
    private Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public T find(Serializable id) {
        return getEntityManager().find(entityClass, id);
    }
    
    public AbstractDAO() {}

    protected abstract EntityManager getEntityManager();
        
    public void create(Entidade entity) {
        getEntityManager().persist(entity);
    }

    public void edit(Entidade entity) {
        getEntityManager().merge(entity);
    }

    public void remove(Integer id) {
        getEntityManager().remove(find(id));
    }
    
    public void persist(Entidade entity) {
        getEntityManager().persist(entity);
    }

    public Entidade find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
}
