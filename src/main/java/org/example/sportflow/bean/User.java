package org.example.sportflow.bean;

public class User {
    private int user_id;
    private String role;

    public User() {}

    public User(int user_id, String role) {
        this.user_id = user_id;
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
