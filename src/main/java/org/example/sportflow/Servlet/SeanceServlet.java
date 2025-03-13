package org.example.sportflow.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.sportflow.Dao.SeanceDao;

import java.io.IOException;

public class SeanceServlet extends HttpServlet {
    private SeanceDao sDao;

    @Override
    public void init() throws ServletException {
        sDao = new SeanceDao();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
