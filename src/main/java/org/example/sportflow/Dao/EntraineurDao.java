package org.example.sportflow.Dao;

import org.example.sportflow.bean.Entraineur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EntraineurDao {
    private Connection con;
    public EntraineurDao() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sportflow","root","");
            System.out.println("Connected to the database successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");;
        }
    }
    public void add_entraineur(Entraineur entraineur){
        System.out.println("jjjjjjjjjjj");
        String sql ="INSERT INTO entraineur(name, specialite) VALUES (?, ?)";
        try(PreparedStatement ps =con.prepareStatement(sql)){

            ps.setString(1,entraineur.getName());
            ps.setString(2,entraineur.getSpecialite());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Entraineur> getAllEntraineur(){
        List<Entraineur> entraineurlist =new ArrayList<>();
        String sql ="select * from entraineur";
        System.out.println("geeeeeet");
        try(PreparedStatement ps=con.prepareStatement(sql); ResultSet rs=ps.executeQuery()){
            System.out.println("in");
            while(rs.next()){
                Entraineur entraineur=new Entraineur();
                entraineur.setE_id(rs.getInt("id_E"));
                entraineur.setName(rs.getString("name"));
                entraineur.setSpecialite(rs.getString("specialite"));
                entraineurlist.add(entraineur);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entraineurlist;
    }
    public Entraineur getEntraineurById(int E_id){
        Entraineur entraineur =null;
        String sql = "select * from entraineur where id_E=?";
        try(PreparedStatement prest = con.prepareStatement(sql)) {
            prest.setInt(1, E_id);
            try (ResultSet res = prest.executeQuery()){
                if (res.next()) {
                    entraineur = new Entraineur();
                    entraineur.setE_id(res.getInt("id_E"));
                    entraineur.setName(res.getString("name"));
                    entraineur.setSpecialite(res.getString("specialite"));


                }

            }

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("membre id not found");
        }
        return entraineur;
    }

    public void modify_entraineur(Entraineur entraineur){
        String sql ="Update entraineur set name=?,specialite=? where id_E=?";
        try(PreparedStatement ps =con.prepareStatement(sql)){
           ps.setString(1, entraineur.getName());
           ps.setString(2, entraineur.getSpecialite());
           ps.setInt(3,entraineur.getE_id());
           ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deleteEntraineur(int E_id){
        String sql = "delete from entraineur where id_E=?";
        try (PreparedStatement ps =con.prepareStatement(sql)){
            ps.setInt(1, E_id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
