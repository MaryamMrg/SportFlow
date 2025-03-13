package org.example.sportflow.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.sportflow.Dao.MembreDao;
import org.example.sportflow.bean.Membre;

import java.io.IOException;
import java.util.List;

@WebServlet("/MembreServlet")
public class MembreServlet extends HttpServlet {

private MembreDao mdao;

    @Override
    public void init() throws ServletException {
        mdao=new MembreDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        System.out.println("ACTION:"+action);
         if ("delete".equals(action)) {
            int id=Integer.parseInt(req.getParameter("id_M"));
            mdao.delete_membre(id);
            resp.sendRedirect(req.getContextPath()+"/MembreServlet");
        } else if ("update".equals(action)) {
            int id=Integer.parseInt(req.getParameter("id_M"));
            Membre membre= mdao.getmembreById(id);
            req.setAttribute("membre",membre);
            req.getRequestDispatcher("UpdateMembre.jsp").forward(req,resp);

        }else {
            List<Membre> membrelist= mdao.get_allmembre();
            req.setAttribute("membrelist",membrelist);
            req.getRequestDispatcher("MembreList.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             String action=req.getParameter("action");
        System.out.println("ACTION:"+action);
              if ("update".equals(action)) {

                 int id=Integer.parseInt(req.getParameter("id_M"));
                 String name =req.getParameter("name");
                 String datenaissance=req.getParameter("date_naissance");
                 String sport=req.getParameter("sport_pratique");
                 Membre membre =new Membre(name,datenaissance,sport);
                 membre.setM_id(id);

                 mdao.modify_membre(membre);
             }else{
                 String name=req.getParameter("name");
                 String datenaissance =req.getParameter("date_naissance");
                 String sport=req.getParameter("sport_pratique");
                 Membre membre =new Membre(name,datenaissance,sport);
                 mdao.add_membre(membre);
             }
      resp.sendRedirect(req.getContextPath()+"/MembreServlet");
    }
}
