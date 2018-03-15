package io.valdezchavez.progpc04.controller;

import io.valdezchavez.progpc04.Util.ConnectDB;
import io.valdezchavez.progpc04.Util.LoggerUtil;
import io.valdezchavez.progpc04.daos.ClienteDao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Date;


@WebServlet("/pdf")
public class ViewReportServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        Integer rows = new ClienteDao().getNumberRows();
        LoggerUtil.getInstance().getLogger().info(" Numero de filas por el reporte : " + rows);
        byte[] bytes = new byte[0];
        try {
            System.out.println(getServletContext().getResource("/").getPath());
            bytes = JasperRunManager.runReportToPdf( getServletContext().getResource("/resources/reports/clientesRpt.jasper").getPath() , null, ConnectDB.getConnection());
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }

        LoggerUtil.getInstance().getLogger().info("Registro de visualizacion de reporte " + new Date().toString());

        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream outStream = response.getOutputStream();
        outStream.write(bytes, 0, bytes.length);
        outStream.flush();
        outStream.close();
    }

}
