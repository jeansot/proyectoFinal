/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uia.is12.business;

import com.uia.is12.data.TaskDAO;
import com.uia.is12.domain.Issues;
import com.uia.is12.domain.Tarea;
import com.uia.is12.domain.User;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean Pierre
 */
public class TaskBL {
    TaskDAO dao = new TaskDAO();

    public TaskBL() {
        this.dao = dao;
    }
    public void agregarTarea(Tarea task)throws SQLException{
        if (dao.exist(task)==false) {
            dao.agregar(task);
        }else{
            JOptionPane.showMessageDialog(null,"Tarea ya existe en base de datos");
        }
    }
    public void eliminarUsuario(Tarea task) throws SQLException, Exception {
        if (dao.exist(task) == true) {
            dao.eliminarTarea(task);
        } else {
            throw new Exception("Tarea no existe");
        }
    }
    
}
