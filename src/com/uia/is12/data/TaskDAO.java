/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uia.is12.data;

import com.uia.is12.connections.MYSQLDB;
import com.uia.is12.domain.Projects;
import com.uia.is12.domain.Tarea;
import com.uia.is12.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jean Pierre
 */
public class TaskDAO {
    MYSQLDB mysqldb = new MYSQLDB();
    public void agregar(Tarea task) throws SQLException{
     mysqldb = new MYSQLDB();
     String sql = "INSERT INTO tarea (id,nombre,descripcion,prioridad,privacidad,asignar) VALUES("+"'"+task.getId()+"'"+","+"'"+task.getNombre()+"'"+",'"+task.getDescripcion()+"','"+task.getPrioridad()+"','"+task.getPrivacidad()+"','"+task.getAsignar()+"')";
     mysqldb.execute(sql);
     mysqldb.closeExecute();
    }
    public boolean exist(Tarea task) throws SQLException{
        boolean existDato = false;
        mysqldb = new MYSQLDB();
        String sql = "SELECT * FROM tarea where id = "+task.getId()+";";
        ResultSet res = mysqldb.executeQuery(sql);
        if(res.next()){
            existDato = true;
        }
        mysqldb.closeExecuteQuery();
        return existDato;
    }
    public ResultSet MostrarTareas(Tarea task)throws SQLException{
       mysqldb = new MYSQLDB();
       String sql = "select * from tarea;";
       mysqldb.execute(sql);
       mysqldb.closeExecute();      
       return mysqldb.executeQuery(sql);
    }
    public void eliminarTarea(Tarea task) throws SQLException{
     mysqldb = new MYSQLDB();
     String sql = "DELETE from tarea where id ="+task.getId()+";";
     mysqldb.execute(sql);
     mysqldb.closeExecute();
    }
}
