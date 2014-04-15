/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uia.is12.data;

import com.uia.is12.connections.MYSQLDB;
import com.uia.is12.domain.Issues;
import com.uia.is12.domain.Projects;
import com.uia.is12.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jean Pierre
 */
public class IssuesDAO {
    MYSQLDB mysqldb = new MYSQLDB();
    public void agregar(Issues is) throws SQLException{
     mysqldb = new MYSQLDB();
     String sql = "INSERT INTO issue (id,nombre,descripcion,prioridad,privacidad,asignar) VALUES("+"'"+is.getId()+"'"+","+"'"+is.getNombre()+"'"+",'"+is.getDescripcion()+"','"+is.getPrioridad()+"','"+is.getPrivacidad()+"','"+is.getAsignar()+"')";
     mysqldb.execute(sql);
     mysqldb.closeExecute();
    }
    public boolean exist(Issues isu) throws SQLException{
        boolean existDato = false;
        mysqldb = new MYSQLDB();
        String sql = "SELECT * FROM issue where id = "+isu.getId()+";";
        ResultSet res = mysqldb.executeQuery(sql);
        if(res.next()){
            existDato = true;
        }
        mysqldb.closeExecuteQuery();
        return existDato;
    }
    public ResultSet MostrarIssues(Issues isu)throws SQLException{
       mysqldb = new MYSQLDB();
       String sql = "select * from issue;";
       mysqldb.execute(sql);
       mysqldb.closeExecute();      
       return mysqldb.executeQuery(sql);
    }
    public void eliminarIssue(Issues is) throws SQLException{
     mysqldb = new MYSQLDB();
     String sql = "DELETE from issue where id ="+is.getId()+";";
     mysqldb.execute(sql);
     mysqldb.closeExecute();
    } 
}
