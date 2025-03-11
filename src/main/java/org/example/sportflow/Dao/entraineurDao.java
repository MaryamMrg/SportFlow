package org.example.sportflow.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class entraineurDao {
    private Connection con;
    public entraineurDao() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sportflow","root","");
            System.out.println("Connected to the database successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");;
        }
    }
}
