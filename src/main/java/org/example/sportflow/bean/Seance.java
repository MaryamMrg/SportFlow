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
}
