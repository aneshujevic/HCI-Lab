package com.example.crud_app.student;

public class Student {
    private final long id;
    private String name;
    private String surname;
    private String gender;
    private String department;

    public Student(long id, String name, String surname, String gender, String department) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
