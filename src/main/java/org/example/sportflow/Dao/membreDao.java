package org.example.sportflow.Dao;

import org.example.sportflow.bean.Membre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class membreDao {
    private Connection con;
    public membreDao() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sportflow","root","");
            System.out.println("Connected to the database successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");;
        }
    }
 public  void add_membre (Membre membre){
        String sql = "insert int membre(id_M,name,datenaissance,sport) values(?,?,?,?)";
 try(PreparedStatement ps=con.prepareStatement(sql)){
     ps.setInt(1,membre.getUser_id());
     ps.setString(2);
 } catch (Exception e) {
     e.printStackTrace();
 }

    }
}
