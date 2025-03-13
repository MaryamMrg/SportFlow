package org.example.sportflow.Dao;

import org.example.sportflow.bean.Membre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MembreDao {
    private Connection con;
    public MembreDao() {
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
        String sql = "insert into membre(name,date_naissance,sport_pratique) values(?,?,?)";
 try(PreparedStatement ps=con.prepareStatement(sql)){

     ps.setString(1,membre.getName());
     ps.setString(2,membre.getDatenaissance());
     ps.setString(3,membre.getSport());
     ps.executeUpdate();
 } catch (Exception e) {
     e.printStackTrace();
 }

    }
    public List<Membre> get_allmembre(){
        System.out.println("hhhhhh");
        List<Membre> membrelist=new ArrayList<>();
        String sql = "select * from membre";
        try(PreparedStatement ps=con.prepareStatement(sql); ResultSet rs= ps.executeQuery()){
            while (rs.next()){
                Membre membre =new Membre();
                membre.setM_id(rs.getInt("id_M"));
                membre.setName(rs.getString("name"));
                membre.setDatenaissance(rs.getString("date_naissance"));
                membre.setSport(rs.getString("sport_pratique"));
                membrelist.add(membre);
                System.out.println("kkkk");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return membrelist;
    }
    public Membre getmembreById(int M_id){
        Membre membre=null;
        String sql = "select * from membre where id_M=?";
        try(PreparedStatement prest = con.prepareStatement(sql)) {
            prest.setInt(1, M_id);
            try (ResultSet res = prest.executeQuery()){
                if (res.next()) {
                    membre = new Membre();
                    membre.setM_id(res.getInt("id_M"));
                    membre.setName(res.getString("name"));
                    membre.setDatenaissance(res.getString("date_naissance"));
                    membre.setSport(res.getString("sport_pratique"));



                }

            }


        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("membre id not found");
        }
        return membre;
    }
    public void modify_membre(Membre membre){
        System.out.println("mmmmmmmmmmmmmmm");
        String sql = "UPDATE membre SET name=?, sport_pratique=?, date_naissance=? WHERE id_M=?";
        try(PreparedStatement ps=con.prepareStatement(sql)){
           ps.setString(1, membre.getName());
           ps.setString(2, membre.getSport());
           ps.setString(3, membre.getDatenaissance());
           ps.setInt(4, membre.getM_id());
           ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void delete_membre(int M_id){
        System.out.println("dddddddddd");
        String sql = "delete from membre where id_M=?";
        try(PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1, M_id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
