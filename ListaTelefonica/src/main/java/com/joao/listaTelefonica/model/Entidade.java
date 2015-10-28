/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joao.listaTelefonica.model;

import java.io.Serializable;


/**
 *
 * @author joao
 */
public interface Entidade extends Serializable {
    
    public abstract void setId(Integer id);
	
    public abstract Integer getId();     
    
}
