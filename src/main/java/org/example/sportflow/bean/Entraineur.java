package org.example.sportflow.bean;

public class Entraineur extends User{
    private int E_id;
    private String name;
    private String Specialite;

    public Entraineur(int user_id, String role, int e_id, String name, String specialite) {
        super(user_id, role);
        E_id = e_id;
        this.name = name;
        Specialite = specialite;
    }

    public Entraineur() {
    }

    public int getE_id() {
        return E_id;
    }

    public void setE_id(int e_id) {
        E_id = e_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialite() {
        return Specialite;
    }

    public void setSpecialite(String specialite) {
        Specialite = specialite;
    }
}
