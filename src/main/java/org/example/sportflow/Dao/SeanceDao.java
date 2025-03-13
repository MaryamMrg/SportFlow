package org.example.sportflow.Dao;

import org.example.sportflow.bean.Entraineur;
import org.example.sportflow.bean.Seance;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeanceDao {
    private Connection con;
    public SeanceDao() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sportflow","root","");
            System.out.println("Connected to the database successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");;
        }
    }
    public  void add_seance(Seance seance){
        String sql = "insert into seance() values(?,?,?)";
        try(PreparedStatement ps=con.prepareStatement(sql)){

            ps.setString(1,seance.getDateheure());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public List<Seance> get_allseance(){
        System.out.println("hhhhhh");
        List<Seance> seancelist=new ArrayList<>();
        String sql = "select * from seance";
        try(PreparedStatement ps=con.prepareStatement(sql); ResultSet rs= ps.executeQuery()){
            while (rs.next()){
                Seance seance =new Seance();
               seance.setM_id(rs.getInt("seance_id"));
                seance.setDateheure(rs.getString("date_heure"));
                seancelist.add(seance);
                System.out.println("kkkk");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return seancelist;
    }
    public Seance getseanceById(int id){
       Seance seance =null;
        String sql = "select * from seance where seance_id=?";
        try(PreparedStatement prest = con.prepareStatement(sql)) {
            prest.setInt(1, id);
            try (ResultSet res = prest.executeQuery()){
                if (res.next()) {
                    seance = new Seance();
                    seance.setM_id(res.getInt("seance_id"));
                    seance.setDateheure(res.getString("date_heure"));




                }

            }


        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("seance id not found");
        }
        return seance;
    }
    public void modify_seance(Seance  seance){
        System.out.println("mmmmmmmmmmmmmmm");
        String sql = "UPDATE seance SET date_heure WHERE seance_id=?";
        try(PreparedStatement ps=con.prepareStatement(sql)){

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void delete_seance(int id){
        System.out.println("dddddddddd");
        String sql = "delete from seance where seance_id=?";
        try(PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
