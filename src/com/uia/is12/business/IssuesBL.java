/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uia.is12.business;

import com.uia.is12.connections.MYSQLDB;
import com.uia.is12.data.IssuesDAO;
import com.uia.is12.domain.Issues;
import com.uia.is12.domain.Projects;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean Pierre
 */
public class IssuesBL {
    private IssuesDAO issuesdao= new IssuesDAO();
    public void agregarIssue(Issues isu)throws SQLException{
        if (issuesdao.exist(isu)==false) {
            issuesdao.agregar(isu);
        }else{
            JOptionPane.showMessageDialog(null,"Issue ya existe en base de datos");
        }
    }
    public void eliminarProyecto(Issues is) throws SQLException, Exception {
        if (issuesdao.exist(is) == true) {
            issuesdao.eliminarIssue(is);
        } else {
            throw new Exception("Issue no existe");
        }
    }
}

