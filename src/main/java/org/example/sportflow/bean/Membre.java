package org.example.sportflow.bean;

public class Membre extends User{
    private int M_id;
    private String name;
    private String datenaissance;
    private String Sport;

    public Membre(int user_id, String role, int m_id, String name, String datenaissance, String sport) {
        super(user_id, role);
        M_id = m_id;
        this.name = name;
        this.datenaissance = datenaissance;
        Sport = sport;
    }

    public int getM_id() {
        return M_id;
    }

    public void setM_id(int m_id) {
        M_id = m_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getSport() {
        return Sport;
    }

    public void setSport(String sport) {
        Sport = sport;
    }
}
