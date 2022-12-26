/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gpsAsist.security.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;


/**
 *
 * @author SNC-CHINANDEGA
 */
@Entity
@Table(name = "tipousuario", catalog = "rrhh", schema = "")

@NamedQueries({
    @NamedQuery(name = "Tipousuario.findAll", query = "SELECT t FROM Tipousuario t"),
    @NamedQuery(name = "Tipousuario.findByIdTipouser", query = "SELECT t FROM Tipousuario t WHERE t.idTipouser = :idTipouser"),
    @NamedQuery(name = "Tipousuario.findByTipo", query = "SELECT t FROM Tipousuario t WHERE t.tipo = :tipo")})
public class Tipousuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPOUSER", nullable = false)
    private Integer idTipouser;
    @Size(max = 50)
    @Column(name = "TIPO", length = 50)
    private String tipo;
    @ManyToMany(mappedBy = "tipousuarioList", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;

    public Tipousuario() {
    }

    public Tipousuario(Integer idTipouser) {
        this.idTipouser = idTipouser;
    }

    public Integer getIdTipouser() {
        return idTipouser;
    }

    public void setIdTipouser(Integer idTipouser) {
        this.idTipouser = idTipouser;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipouser != null ? idTipouser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipousuario)) {
            return false;
        }
        Tipousuario other = (Tipousuario) object;
        if ((this.idTipouser == null && other.idTipouser != null) || (this.idTipouser != null && !this.idTipouser.equals(other.idTipouser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.gpsAsist.security.modelo.Tipousuario[ idTipouser=" + idTipouser + " ]";
    }
    
}
