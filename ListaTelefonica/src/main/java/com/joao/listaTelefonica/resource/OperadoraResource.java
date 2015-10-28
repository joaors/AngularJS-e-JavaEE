/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joao.listaTelefonica.resource;

import com.joao.listaTelefonica.dao.OperadoraDAO;
import com.joao.listaTelefonica.model.Contato;
import com.joao.listaTelefonica.model.Operadora;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author joao
 */
@Path("operadora")
@Produces(MediaType.APPLICATION_JSON)
public class OperadoraResource {
    
    @Inject
    private OperadoraDAO dao;
    
    @GET
    @Path("{id}")
    public Operadora buscar(@PathParam("id") Integer id) {
        Operadora operadora = dao.find(id);
        return operadora;
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
    public Response buscarTodos() {    
        List<Operadora> operadoras = dao.findAll();
        GenericEntity<List<Operadora>> operadoraWrapper = new GenericEntity<List<Operadora>>(operadoras) {};        
        return Response
                .status(Response.Status.OK)
                .entity(operadoraWrapper)
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }   
    
}
