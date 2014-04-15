/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uia.is12.domain;

import java.util.ArrayList;

/**
 *
 * @author Jean Pierre
 */
public class User {
    Issues is = new Issues();
    private String nombre;
    private String apellidos;
    private int edad;
    private String contraseña;
    private String nombreDeUsuario;
    private String usuarioLog;
    private ArrayList<Issues> issueAsignado;
    private ArrayList proyectoAsignado;
    /*
     * Mae las variables que estan en todo el domain,  no son del todo fijas aún, por ejemplo esos dos arraylist no sé si los vamos a concervar
     * Al igual que en las otras clases del domian, ninguna está completada por o que solo voy a comentar esta
     
     */
    public User() {
    }

    public Issues getIs() {
        return is;
    }

    public void setIs(Issues is) {
        this.is = is;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getUsuarioLog() {
        return usuarioLog;
    }

    public void setUsuarioLog(String usuarioLog) {
        this.usuarioLog = usuarioLog;
    }

    public ArrayList<Issues> getIssueAsignado() {
        return issueAsignado;
    }

    public void setIssueAsignado(ArrayList<Issues> issueAsignado) {
        this.issueAsignado = issueAsignado;
    }

    public ArrayList getProyectoAsignado() {
        return proyectoAsignado;
    }

    public void setProyectoAsignado(ArrayList proyectoAsignado) {
        this.proyectoAsignado = proyectoAsignado;
    }

    
    
}
