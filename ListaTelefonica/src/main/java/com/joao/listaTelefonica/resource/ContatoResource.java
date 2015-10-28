/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joao.listaTelefonica.resource;

import com.joao.listaTelefonica.dao.ContatoDAO;
import com.joao.listaTelefonica.model.Contato;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author joao
 */
@Path("contato")
@Produces(MediaType.APPLICATION_JSON)
public class ContatoResource {
    
    @Inject
    private ContatoDAO dao;
    
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Contato buscar(@PathParam("id") Integer id) {
        Contato contato = dao.find(id);
        return contato;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criar(Contato artefato) {
        dao.persist(artefato);
       return Response  
               .status(Response.Status.CREATED)
               .entity(artefato)
               .build(); 
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contato> buscarTodos() {    
        List<Contato> contatos = dao.findAll();
        return contatos;
    }   
    
}
