/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uia.is12.business;

import com.uia.is12.connections.MYSQLDB;
import com.uia.is12.data.ProjectDAO;
import com.uia.is12.domain.Issues;
import com.uia.is12.domain.Projects;
import com.uia.is12.domain.Tarea;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jean Pierre
 */
public class ProjectBL {
    ProjectDAO dao = new ProjectDAO();
    
    public ProjectBL() {
        this.dao = new ProjectDAO();
    }
    
    public void agregarProyecto(Projects pr)throws SQLException{
        if (dao.exist(pr)==false) {
            dao.agregar(pr);
        }else {
            throw new SQLException("Ya el Proyecto existe en la base de datos");
        }
        
    }
    public void eliminarProyecto(Projects pr) throws SQLException, Exception {
        if (dao.exist(pr) == true) {
            dao.eliminarProyecto(pr);
        } else {
            throw new Exception("Proyecto no existe");
        }
    }
    
}
