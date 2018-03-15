/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.valdezchavez.progpc04.Util;

import io.valdezchavez.progpc04.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Christian
 */
public class FactoryServiceImpl implements FactoryService {
    
    public FactoryServiceImpl() {
        
    }
    
    @Override
    public int executeNowQuery(String query, Object[] params) throws SQLException {
        int execute = 0;
        try(Connection cn = ConnectDB.getConnection();
            PreparedStatement ps = cn.prepareStatement(query)){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i, params[i]);
            }
            execute = ps.executeUpdate();
        }
        return execute;
    }
    
    @Override
    public List<Cliente> executeResult(String query, Object[] params) throws SQLException {
        List<Cliente> list = new ArrayList<>();
        try(Connection cn = ConnectDB.getConnection();
            PreparedStatement ps = cn.prepareStatement(query)){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i, params[i]);
            }
            ResultSet rs = ps.executeQuery();
            Cliente cli;
            while (rs.next()) {
                cli = new Cliente();
                cli.setIdCliente(rs.getInt("idcliente"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setNacimiento(rs.getString("nacimiento"));
                list.add(cli);
            }
        }
        return list;
    }
    
}
