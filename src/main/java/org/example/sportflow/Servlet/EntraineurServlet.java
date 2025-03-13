package org.example.sportflow.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.sportflow.Dao.EntraineurDao;
import org.example.sportflow.bean.Entraineur;

import java.io.IOException;
import java.util.List;
@WebServlet("/EntraineurServlet")
public class EntraineurServlet extends HttpServlet {
    private EntraineurDao eDao;

    @Override
    public void init() throws ServletException {
        eDao=new EntraineurDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        System.out.println("ACTION:"+action);
        if("update".equals(action)){
            int id=Integer.parseInt(req.getParameter("id_E"));
            Entraineur entraineur=eDao.getEntraineurById(id);
            req.setAttribute("entraineur",entraineur);
            req.getRequestDispatcher("UpdateEntraineur.jsp").forward(req,resp);

        }else if("delete".equals(action)){
            int id=Integer.parseInt(req.getParameter("id_E"));
            eDao.deleteEntraineur(id);
            resp.sendRedirect(req.getContextPath()+"/EntraineurServlet");
        }else{
            List<Entraineur> Entraineurlist =eDao.getAllEntraineur();
            req.setAttribute("Entraineurlist",Entraineurlist);
            req.getRequestDispatcher("EntraineurList.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String action=req.getParameter("action");
        System.out.println("ACTION:"+action);
        if("update".equals(action)){
            int id=Integer.parseInt(req.getParameter("id_E"));
            String name=req.getParameter("name");
            String specialite=req.getParameter("specialite");
            Entraineur entraineur=new Entraineur( name,specialite);
            entraineur.setE_id(id);
            eDao.modify_entraineur(entraineur);
        }else {

            String name=req.getParameter("name");
            String specialite=req.getParameter("specialite");
            Entraineur entraineur=new Entraineur( name,specialite);

            eDao.add_entraineur(entraineur);

        }
        resp.sendRedirect(req.getContextPath()+"/EntraineurServlet");
    }
}
