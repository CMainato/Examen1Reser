/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades.sesion;

import com.reserb.entidades.Reser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user
 */
@Stateless
public class ReserFacade extends AbstractFacade<Reser> implements ReserFacadeLocal {

    @PersistenceContext(unitName = "Gestion de canchas")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReserFacade() {
        super(Reser.class);
    }
    
}
