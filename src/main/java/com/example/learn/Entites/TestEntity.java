package com.example.learn.Entites;


import org.springframework.stereotype.Component;

import java.util.HashMap;

public class TestEntity {

    private HashMap<String, Object> testMap = new HashMap<>();

    public HashMap<String, Object> getTestMap() { return this.testMap;}
}
