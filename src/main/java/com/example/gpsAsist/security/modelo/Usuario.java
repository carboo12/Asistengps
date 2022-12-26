/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gpsAsist.security.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author SNC-CHINANDEGA
 */
@Entity
@Table(name = "usuario", catalog = "rrhh", schema = "")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNombreUser", query = "SELECT u FROM Usuario u WHERE u.nombreUser = :nombreUser"),
    @NamedQuery(name = "Usuario.findByContrase\u00f1a", query = "SELECT u FROM Usuario u WHERE u.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "Usuario.findByTipo", query = "SELECT u FROM Usuario u WHERE u.tipo = :tipo"),
    @NamedQuery(name = "Usuario.findByNombreCompleto", query = "SELECT u FROM Usuario u WHERE u.nombreCompleto = :nombreCompleto"),
    @NamedQuery(name = "Usuario.findByFecha", query = "SELECT u FROM Usuario u WHERE u.fecha = :fecha"),
    @NamedQuery(name = "Usuario.findByDisposi", query = "SELECT u FROM Usuario u WHERE u.disposi = :disposi")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO", nullable = false)
    private Integer idUsuario;
    @Size(max = 50)
    @Column(name = "NOMBRE_USER", length = 50)
    private String nombreUser;
    @Size(max = 50)
    @Column(name = "CONTRASE\u00d1A", length = 50)
    private String contraseña;
    @Column(name = "TIPO")
    private Integer tipo;
    @Size(max = 255)
    @Column(name = "NOMBRE_COMPLETO", length = 255)
    private String nombreCompleto;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 255)
    @Column(name = "DISPOSI", length = 255)
    private String disposi;
    @JoinTable(name = "roles", joinColumns = {
        @JoinColumn(name = "idUsuario", referencedColumnName = "ID_USUARIO", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "idTipo", referencedColumnName = "ID_TIPOUSER", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Tipousuario> tipousuarioList = new HashSet<>();

    public Usuario() {
    }
    

    public Usuario(String nombreUser, String contraseña, Integer tipo, String nombreCompleto, Date fecha,
			String disposi) {
		super();
		this.nombreUser = nombreUser;
		this.contraseña = contraseña;
		this.tipo = tipo;
		this.nombreCompleto = nombreCompleto;
		this.fecha = fecha;
		this.disposi = disposi;
	}


	public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDisposi() {
        return disposi;
    }

    public void setDisposi(String disposi) {
        this.disposi = disposi;
    }

    
    

    public Set<Tipousuario> getTipousuarioList() {
		return tipousuarioList;
	}

	public void setTipousuarioList(Set<Tipousuario> tipousuarioList) {
		this.tipousuarioList = tipousuarioList;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.gpsAsist.security.modelo.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
