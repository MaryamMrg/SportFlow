package org.example.sportflow.bean;

public class entraineur extends User{
    private int E_id;
    private String name;
    private String Specialite;

    public entraineur(int user_id, String role, int e_id, String name, String specialite) {
        super(user_id, role);
        E_id = e_id;
        this.name = name;
        Specialite = specialite;
    }
}
