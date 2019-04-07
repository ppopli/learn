package com.example.learn.Entites;

public class Student {

    String name;
    String id;
    Address addr;

    public Student(String name, String id, Address addr) {
        this.name = name;
        this.id = id;
        this.addr = addr;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }
}
