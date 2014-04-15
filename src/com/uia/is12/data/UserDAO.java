/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uia.is12.data;

import com.uia.is12.connections.MYSQLDB;
import com.uia.is12.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;


/**
 *
 * @author Jean Pierre
 */
public class UserDAO {
    private MYSQLDB mysqldb;

    public UserDAO() {
    }
    // necesitamos un constructor vacio, solo para poder acceder a la clase desde otro lugar
    //CrearUsuario es solo para el loggin, esta clase va a tratar solo con el usuario, no va a hacer nada más alla de él
    // una vez creado el usuario (en el registro) se podrá acceder como un inicio de sesión
    public void crearUsario(User usuario) throws SQLException{
     mysqldb = new MYSQLDB();
     String sql = "INSERT INTO user (NombreDeUsuario,Nombre,Apellido,contraseña,edad) VALUES("+"'"+usuario.getNombreDeUsuario()+"'"+","+"'"+usuario.getNombre()+"'"+",'"+usuario.getApellidos()+"','"+usuario.getContraseña()+"',"+usuario.getEdad()+")";
     mysqldb.execute(sql);
     mysqldb.closeExecute();
    }
    //en un inicio de sesión necesitamos verificar si el usuario existe, entonces necesitamos comprabarlo por su ID, en este caso yo preferí usar en vez del Id, un nombre de usuario único
    public boolean verificarUsuario(User usuario) throws SQLException{
        boolean exist = false;
        mysqldb = new MYSQLDB();
        String sql = "SELECT * from user WHERE NombreDeUsuario='"+usuario.getNombreDeUsuario()+"' AND contraseña='"+usuario.getContraseña()+"'";
        ResultSet res = mysqldb.executeQuery(sql); //este resultset es el que va a guatdar el dato solicitado (si existe el usuario y concuerda con la contraseña que se le asignó al registro, podemos contuniar)
        if(res.next()){
            exist = true;
        }
        mysqldb.closeExecuteQuery();
        return exist;
    } 
    //este es solo para verificar si el nombre de usuario ya está en base de datos
    public boolean exist(User usuario) throws SQLException{
        boolean existDato = false;
        mysqldb = new MYSQLDB();
        String sql = "SELECT * FROM user where NombreDeUsuario = "+"'"+usuario.getNombreDeUsuario()+"'"+";";
        ResultSet res = mysqldb.executeQuery(sql);
        if(res.next()){
            existDato = true;
        }
        mysqldb.closeExecuteQuery();
        return existDato;
    }
    //devuelve un objeto de tipo resultset por que necesitamos el valor que encontramos en la base de datos para poderlo mostrar
    public ResultSet MostrarUsuarios(User usuario)throws SQLException{
       mysqldb = new MYSQLDB();
       String sql = "select * from user;";
       mysqldb.execute(sql);
       mysqldb.closeExecute();      
       return mysqldb.executeQuery(sql);
    }
    //debemos ir a instancia en el Business todo lo que es proveniente del DAO
    
    public void mostrarJtable(User usuario)throws SQLException{
        mysqldb = new MYSQLDB();
        String sql = "select NombreDeUsuario, Nombre, Apellido from user order by Nombre;";
        mysqldb.execute(sql);
        mysqldb.closeExecute();
        
    }
    public ResultSet MostrarUserName(User usuario)throws SQLException{
       mysqldb = new MYSQLDB();
       String sql = "select NombreDeUsuario from user;";
       mysqldb.execute(sql);
       mysqldb.closeExecute();      
       return mysqldb.executeQuery(sql);
    }
     public void eliminarUsario(User usuario) throws SQLException{
     mysqldb = new MYSQLDB();
     String sql = "DELETE from user where NombreDeUsuario =" +"'"+usuario.getNombreDeUsuario()+"';";
     mysqldb.execute(sql);
     mysqldb.closeExecute();
    }
     public boolean existe(User usuario) throws SQLException{
        boolean existDato = true;
        mysqldb = new MYSQLDB();
        String sql = "SELECT * FROM user where NombreDeUsuario = "+"'"+usuario.getNombreDeUsuario()+"'"+";";
        ResultSet res = mysqldb.executeQuery(sql);
        if(res.next()){
            existDato = false;
        }
        mysqldb.closeExecuteQuery();
        return existDato;
    }
    
}
