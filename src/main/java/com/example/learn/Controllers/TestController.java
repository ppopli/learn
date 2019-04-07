package com.example.learn.Controllers;

import com.example.learn.Entites.Address;
import com.example.learn.Entites.Student;
import com.example.learn.Entites.TestEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final String TEST_MAP_KEY = "testMap";


    @GetMapping("/getStudent")
    Student getStudent() {
        Student s = createStudent();
        Student s1 = null;
        try {
            TestEntity testEntity = new TestEntity();
            JsonNode jsonNode = objectMapper.readTree(objectMapper.writeValueAsString(s));
            testEntity.getTestMap().put(TEST_MAP_KEY, jsonNode);
            JsonNode jsonObject = objectMapper.readTree(objectMapper.writeValueAsString(testEntity));

            TestEntity testEntity1 = objectMapper.treeToValue(jsonObject, TestEntity.class);
            s1 = objectMapper.convertValue(testEntity1.getTestMap().get(TEST_MAP_KEY), Student.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (null == s1) {
            return new Student();
        } else {
            return s1;
        }
    }

    public static Student createStudent() {
        Student student = new Student();
        student.setName("Pulkit");
        student.setId("1");

        Address address = new Address();
        address.setCity("New Delhi");
        address.setCountry("India");
        address.setState("Delhi");
        address.setHomeAddress("JanakPuri");

        student.setAddr(address);

        return student;
    }
}
