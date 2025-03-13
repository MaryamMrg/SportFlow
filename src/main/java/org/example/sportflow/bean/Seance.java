package org.example.sportflow.bean;

public class Seance {
    private int Seance_id;
    private int E_id;
    private int M_id;
    private String dateheure;

    public Seance(int seance_id, int e_id, int m_id, String dateheure) {
        Seance_id = seance_id;
        E_id = e_id;
        M_id = m_id;
        this.dateheure = dateheure;
    }

    public Seance() {

    }

    public int getSeance_id() {
        return Seance_id;
    }

    public void setSeance_id(int seance_id) {
        Seance_id = seance_id;
    }

    public String getDateheure() {
        return dateheure;
    }

    public void setDateheure(String dateheure) {
        this.dateheure = dateheure;
    }

    public int getM_id() {
        return M_id;
    }

    public void setM_id(int m_id) {
        M_id = m_id;
    }

    public int getE_id() {
        return E_id;
    }

    public void setE_id(int e_id) {
        E_id = e_id;
    }
}
