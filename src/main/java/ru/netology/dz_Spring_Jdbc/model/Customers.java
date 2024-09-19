package ru.netology.dz_Spring_Jdbc.model;


public class Customers {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String phoneNamber;

    public Customers(int id, String name, String surname, int age, String phoneNamber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNamber = phoneNamber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNamber() {
        return phoneNamber;
    }

    public void setPhoneNamber(String phoneNamber) {
        this.phoneNamber = phoneNamber;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phoneNamber='" + phoneNamber + '\'' +
                '}';
    }
}
