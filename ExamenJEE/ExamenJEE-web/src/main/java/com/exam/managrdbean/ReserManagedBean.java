/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.managrdbean;

import com.entidades.sesion.ReserFacadeLocal;
import com.exam.managrdbean.ManagedBeanInterface;
import com.reserb.entidades.Reser;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author user
 */
@Named(value = "reserManagedBean")

@ViewScoped
public class ReserManagedBean implements Serializable,ManagedBeanInterface<Reser>{

    /**
     * Creates a new instance of ReserManagedBean
     */
    
    @EJB
    private ReserFacadeLocal reserFacadeLocal;
    
    public ReserManagedBean() {
    }
    private List<Reser> listaReser;
    private Reser reser;
    
    @PostConstruct
    public void init(){
    
        //listar
        listaReser = reserFacadeLocal.findAll();
        
    }

    @Override
    public void nuebo() {
       
        reser= new Reser();
    }

    
    
    @Override
    public void grabar() {
        
        try{
        if(reser.getId()==null){
            reserFacadeLocal.create(reser);
            
        }else{
            reserFacadeLocal.edit(reser);
        }
        reser=null;
        listaReser=reserFacadeLocal.findAll();
        mostrarMensajeTry("guardado con exito",FacesMessage.SEVERITY_INFO);
        }catch(Exception e){
        mostrarMensajeTry("no se pudo guardar",FacesMessage.SEVERITY_ERROR);    
        }
    }

    @Override
    public void seleccionar(Reser r) {
        reser =r;
        
    }

    @Override
    public void eliminar(Reser r) {
        
        try {
            reserFacadeLocal.remove(r);
            listaReser = reserFacadeLocal.findAll();
            mostrarMensajeTry("eliminado con exito",FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            mostrarMensajeTry("no se pudo eliminar",FacesMessage.SEVERITY_ERROR);
        }
    }

    @Override
    public void cancelar() {
        
        reser =null;
    }

    public List<Reser> getListaReser() {
        return listaReser;
    }

    public void setListaReser(List<Reser> listaReser) {
        this.listaReser = listaReser;
    }

    public Reser getReser() {
        return reser;
    }

    public void setReser(Reser reser) {
        this.reser = reser;
    }
    
   
    
}
