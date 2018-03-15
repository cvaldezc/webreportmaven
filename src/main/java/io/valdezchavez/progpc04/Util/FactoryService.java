/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.valdezchavez.progpc04.Util;

import io.valdezchavez.progpc04.domain.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Christian
 */
public interface FactoryService {
    
    /**
     *
     * @param query
     * @param params
     * @return
     * @throws SQLException
     */
    public int executeNowQuery(String query, Object[] params) throws SQLException;
    
    /**
     *
     * @param query
     * @param params
     * @return
     * @throws SQLException
     */
    public List<Cliente> executeResult(String query, Object[] params) throws SQLException;
    
}
