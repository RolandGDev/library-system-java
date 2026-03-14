package com.library.model;

public class Member {
    private int id;
    private String name;
    private String email;

    public Member(int id, String name, String email) {
        if(name==null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if(email==null || email.isBlank()) {
            throw new IllegalArgumentException("email cannot be null or empty");
        }
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
