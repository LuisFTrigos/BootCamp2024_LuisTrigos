package com.example.emazon_aux.domain.model;


import com.example.emazon_aux.domain.util.validations.Validations;

public class UserModel {

    private Long id;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private RoleModel role;
    private int document;
    private String phone;

    public UserModel() {
    }

    public UserModel(Long id, String name, String lastName, String password,
                     String email, RoleModel role, int document, String phone) {
        Validations valid = new Validations();
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.role = role;
        this.document = document;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
