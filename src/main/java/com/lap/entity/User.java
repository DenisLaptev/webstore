package com.lap.entity;

import com.lap.Role;

public class User {
    private Long id;
    private String name;
    private String secondName;
    private int age;
    private String email;
    private String login;
    private String password;
    private Role role;
    //private List<Product> listOfUserProducts = new ArrayList<>();


    public User() {
    }

    public User(String name,
                String secondName,
                int age,
                String email,
                String login,
                String password) {


        setName(name);
        setSecondName(secondName);
        setAge(age);
        setEmail(email);
        setLogin(login);
        setPassword(password);
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}' + "\n";
    }
}
