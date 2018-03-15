package io.valdezchavez.progpc04.daos;

import io.valdezchavez.progpc04.Util.ConnectDB;
import io.valdezchavez.progpc04.Util.LoggerUtil;
import io.valdezchavez.progpc04.domain.Cliente;
import io.valdezchavez.progpc04.domain.Correo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClienteDao {


    public boolean insert(Cliente client, List<Correo> emails) throws SQLException {
        boolean result = false;
        StringBuilder queryBedside = new StringBuilder();
        StringBuilder queryIdClient = new StringBuilder();
        StringBuilder queryEmails = new StringBuilder();

        queryBedside.append("INSERT INTO clientes ");
        queryBedside.append("(nombres, apellidos, nacimiento) ");
        queryBedside.append("VALUES(?, ?, ?) ");

        queryIdClient.append("SELECT MAX(idcliente) FROM clientes");

        queryEmails.append("INSERT INTO correos ");
        queryEmails.append("(idcliente, correo) ");
        queryEmails.append("VALUES(?, ?)");

        Connection cn = ConnectDB.getConnection();

        if (cn != null) {
            try {
                cn.setAutoCommit(false);

                PreparedStatement psBedside = cn.prepareStatement(queryBedside.toString());
                psBedside.setString(1, client.getNombres());
                psBedside.setString(2, client.getApellidos());
                psBedside.setObject(3, client.getNacimiento().toString());
                int rowsAffectedBedside = psBedside.executeUpdate();

                if (rowsAffectedBedside == 0) {
                    throw new SQLException("La Cabecera no se ha guardado");
                }

                PreparedStatement psKey = cn.prepareStatement(queryIdClient.toString());
                ResultSet rsKey = psKey.executeQuery();
                Integer keyClient = 0;
                if (rsKey.next()) {
                    keyClient = rsKey.getInt(1);
                }

                PreparedStatement psEmails = cn.prepareStatement(queryEmails.toString());
                for (Correo email : emails) {
                    psEmails.setInt(1, keyClient);
                    psEmails.setString(2, email.getCorreo());

                    psEmails.addBatch();
                }

                int[] rowsAffectedDetails = psEmails.executeBatch();
                if (rowsAffectedDetails == null) {
                    throw new SQLException("0 filas para Detalla de Correo");
                }
                result = true;
            } catch (SQLException ex) {
                System.out.println(" Excep: " + ex.getMessage());
                LoggerUtil.getInstance().getLogger().error(ex.getMessage());
                result = false;
            } finally {
                try {
                    if (result) {
                        cn.commit();
                    } else {
                        cn.rollback();
                    }
                    cn.setAutoCommit(true);
                } catch (SQLException ex) {
                    System.out.println(" Excep Rollback: " + ex.getMessage());
                    LoggerUtil.getInstance().getLogger().error(ex.getMessage());
                }
            }
        }
        return result;
    }

    public List<Cliente> getEntities() {
        return null;
    }

    public int getNumberRows() {
        String query = "SELECT count(*) FROM clientes c " +
                "INNER JOIN correos m " +
                "ON c.idcliente = m.idcliente ";
        int numberRows = 0;
        Connection cn = ConnectDB.getConnection();

        if (cn != null) {
            try (PreparedStatement psCounter = cn.prepareStatement(query);
                 ResultSet rows = psCounter.executeQuery();) {

                if (rows.next())
                    numberRows = rows.getInt(1);
            } catch (SQLException ex) {
                System.out.println(" Excep: " + ex.getMessage());
                LoggerUtil.getInstance().getLogger().error(ex.getMessage());
                numberRows = 0;
            }
        }
        return numberRows;
    }
}
