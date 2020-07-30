/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reserb.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "reser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reser.findAll", query = "SELECT r FROM Reser r")
    , @NamedQuery(name = "Reser.findById", query = "SELECT r FROM Reser r WHERE r.id = :id")
    , @NamedQuery(name = "Reser.findByNombre", query = "SELECT r FROM Reser r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Reser.findByApellido", query = "SELECT r FROM Reser r WHERE r.apellido = :apellido")
    , @NamedQuery(name = "Reser.findByCancha", query = "SELECT r FROM Reser r WHERE r.cancha = :cancha")
    , @NamedQuery(name = "Reser.findByFecha", query = "SELECT r FROM Reser r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Reser.findByDescripcion", query = "SELECT r FROM Reser r WHERE r.descripcion = :descripcion")})
public class Reser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 50)
    @Column(name = "cancha")
    private String cancha;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 60)
    @Column(name = "descripcion")
    private String descripcion;

    public Reser() {
    }

    public Reser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCancha() {
        return cancha;
    }

    public void setCancha(String cancha) {
        this.cancha = cancha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reser)) {
            return false;
        }
        Reser other = (Reser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.reserb.entidades.Reser[ id=" + id + " ]";
    }
    
}
