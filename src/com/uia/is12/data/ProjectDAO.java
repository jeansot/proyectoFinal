/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uia.is12.data;

import com.uia.is12.connections.MYSQLDB;
import com.uia.is12.domain.Issues;
import com.uia.is12.domain.Projects;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jean Pierre
 */
public class ProjectDAO {
    MYSQLDB mysqldb = new MYSQLDB();
    public void agregar(Projects pr) throws SQLException{
     mysqldb = new MYSQLDB();
     String sql = "INSERT INTO proyectos (id,nombre,descripcion,prioridad,privacidad,asignar) VALUES("+"'"+pr.getId()+"'"+","+"'"+pr.getNombre()+"'"+",'"+pr.getDescripcion()+"','"+pr.getPrioridad()+"','"+pr.getPrivacidad()+"','"+pr.getAsignar()+"')";
     mysqldb.execute(sql);
     mysqldb.closeExecute();
    }
    public boolean exist(Projects pr) throws SQLException{
        boolean existDato = false;
        mysqldb = new MYSQLDB();
        String sql = "SELECT * FROM proyectos where id = "+pr.getId()+";";
        ResultSet res = mysqldb.executeQuery(sql);
        if(res.next()){
            existDato = true;
        }
        mysqldb.closeExecuteQuery();
        return existDato;
    }
    public ResultSet MostrarProyectos(Projects pr)throws SQLException{
       mysqldb = new MYSQLDB();
       String sql = "select nombre from proyectos;";
       mysqldb.execute(sql);
       mysqldb.closeExecute();      
       return mysqldb.executeQuery(sql);
    }
    public ResultSet MostrarProyectosEnTable(Projects pr)throws SQLException{
       mysqldb = new MYSQLDB();
       String sql = "select * from proyectos;";
       mysqldb.execute(sql);
       mysqldb.closeExecute();      
       return mysqldb.executeQuery(sql);
    }
   public void eliminarProyecto(Projects pr) throws SQLException{
     mysqldb = new MYSQLDB();
     String sql = "DELETE from proyectos where id ="+pr.getId()+";";
     mysqldb.execute(sql);
     mysqldb.closeExecute();
    } 
    
}
