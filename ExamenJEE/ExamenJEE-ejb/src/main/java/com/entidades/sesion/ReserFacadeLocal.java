/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades.sesion;

import com.reserb.entidades.Reser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface ReserFacadeLocal {

    void create(Reser reser);

    void edit(Reser reser);

    void remove(Reser reser);

    Reser find(Object id);

    List<Reser> findAll();

    List<Reser> findRange(int[] range);

    int count();
    
}
