package com.dm.thanks.Model;

public class User {
    private int id;
    private String name;
    private String email;
    private int level_access;

    public User(int id, String name, String email, int level_access) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.level_access = level_access;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getLevel_access() {
        return level_access;
    }
}
