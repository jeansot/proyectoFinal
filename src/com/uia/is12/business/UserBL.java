/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uia.is12.business;

import com.uia.is12.connections.MYSQLDB;
import com.uia.is12.data.UserDAO;
import com.uia.is12.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jean Pierre
 */
public class UserBL {
    // comenzamos instanciando el DAO igual en el contructor
    UserDAO userDAO = new UserDAO();
    MYSQLDB mysqldb = new MYSQLDB();

    public UserBL() {
        this.userDAO = new UserDAO();
    }
    // esto es para comprobar si se puede añadir el usuario, del método crearUsuario del DAO, eciste? no? enotnces creelo
    public void agregarUsuario(User user) throws SQLException, Exception {
        if (userDAO.exist(user) == false) {
            userDAO.crearUsario(user);
        } else {
            throw new Exception("Ya el usuario existe en la base de datos");
        }
    }
    //este es igual pero para el inicio de sesión
    public boolean verificarUsuarioExiste(User user) throws SQLException, Exception {
        boolean v;
        if (userDAO.exist(user) == true) {
            v = userDAO.verificarUsuario(user);
        } else {
            throw new Exception("No existe");
        }
        return v;
    }
    //ya habíamos verificado que el usuario estaba en base de datos (return res, que era un objeto resultset), entonces, si existe, que lo muestre
    public ResultSet mostrarUsuarios(User usuario) throws SQLException{
        if (userDAO.exist(usuario)) {
            userDAO.MostrarUsuarios(usuario);
        } else {
            throw new SQLException("No se puede imprimir Usuario por que no existe en la base de datos");
        }
        return null;
    }
    public void eliminarUsuario(User user) throws SQLException, Exception {
        if (userDAO.exist(user) == true) {
            userDAO.eliminarUsario(user);
        } else {
            throw new Exception("Nombre de Usuario no existe en la base de datos");
        }
    }
    
    
    
}
