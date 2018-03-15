package io.valdezchavez.progpc04.controller;

import io.valdezchavez.progpc04.daos.ClienteDao;
import io.valdezchavez.progpc04.domain.Cliente;
import io.valdezchavez.progpc04.domain.Correo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/register")
public class RegistrarClienteServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = null;
        out = response.getWriter();

        out.print("regrese al registro!");
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("nameClient");
            String lastName = request.getParameter("lastnameClient");

            System.out.println(name);
            System.out.println(lastName);
            String birth = request.getParameter("birthClient");
            String[] mails = request.getParameterValues("mails");

            System.out.println(birth.toString());
            System.out.println(Arrays.toString(mails));

            ClienteDao cDao = new ClienteDao();

            List<Correo> mailList = new ArrayList<>();
            Arrays.asList(mails).forEach(item -> mailList.add(new Correo(item)));
            boolean state = cDao.insert(new Cliente(name, lastName, birth), mailList);
            if (state)
                request.getRequestDispatcher("/views/success.jsp").forward(request, response);
            else
                request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
            request.setAttribute("exception", ex.getMessage());
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }

    }

}
