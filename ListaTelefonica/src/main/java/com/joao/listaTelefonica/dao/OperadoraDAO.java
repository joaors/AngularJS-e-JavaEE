/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joao.listaTelefonica.dao;

import com.joao.listaTelefonica.model.Operadora;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author joao
 */
@Stateless
public class OperadoraDAO extends AbstractDAO<Operadora>{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperadoraDAO() {
        super(Operadora.class);
    }     
    
}
