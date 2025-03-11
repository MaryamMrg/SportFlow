package org.example.sportflow.Dao;

import org.example.sportflow.bean.Membre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
     ps.setString(2,membre.getName());
     ps.setString(3,membre.getDatenaissance());
     ps.setString(4,membre.getSport());
 } catch (Exception e) {
     e.printStackTrace();
 }

    }
    public List<Membre> get_allmembre(){
        List<Membre> memberlist=new ArrayList<>();
        String sql = "select * from membre";
        try(PreparedStatement ps=con.prepareStatement(sql); ResultSet rs= ps.executeQuery()){
            while (rs.next()){
                Membre membre =new Membre();
                membre.setM_id(rs.getInt("M_id"));
                membre.setName(rs.getString("name"));
                membre.setDatenaissance(rs.getString("datenaissance"));
                membre.setSport(rs.getString("sport"));
                memberlist.add(membre);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return memberlist;
    }
    public Membre getmembreById(int M_id){
        Membre membre=null;
        String sql = "select * from membre where M_id=?";
        try(PreparedStatement prest = con.prepareStatement(sql)) {
            prest.setInt(1, M_id);
            try (ResultSet res = prest.executeQuery()){
                if (res.next()) {
                    membre = new Membre();
                    membre.setM_id(res.getInt("M_id"));
                    membre.setName(res.getString("name"));
                    membre.setDatenaissance(res.getString("datenaissance"));
                    membre.setSport(res.getString("sport"));



                }

            }


        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("membre id not found");
        }
        return membre;
    }
    public void modify_membre(Membre membre){
        String sql = "update membre set name=?,sport=?, datenaissance =? where M_id=?";
        try(PreparedStatement ps=con.prepareStatement(sql)){
           ps.setString(1, membre.getName());
           ps.setString(2, membre.getSport());
           ps.setString(3, membre.getDatenaissance());
           ps.setInt(4, membre.getM_id());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void delete_membre(int M_id){
        String sql = "delete from membre where M_id=?";
        try(PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1, M_id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
