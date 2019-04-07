package com.example.learn.Controllers.udemy.hibernate.controllers;

import com.example.learn.Entites.udemy.hibernate.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hibernate")
public class hibernateController {

    private SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Employee.class)
                                            .buildSessionFactory();

    @PostMapping(value = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addEmployee(@RequestBody Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        boolean isSuccessful = false;
        try {
            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();
            isSuccessful = true;
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isSuccessful;
    }

    @GetMapping(value = "/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = null;
        try {
            session.beginTransaction();
            employee = session.get(Employee.class, id);
            session.getTransaction().commit();
        } catch(Exception e) {
            return  new ResponseEntity<>(new Employee(), HttpStatus.OK);
        } finally {
            session.close();
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping(value = "/getEmployees")
    public List<Employee> getEmployes () {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> employees = null;
        try {
            session.beginTransaction();
            employees = (List<Employee>) session.createQuery("from Employee").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
             session.close();
        }
        return  employees;
    }

    @GetMapping(value = "/deleteEmployee/{id}")
    public List<Employee> deleteEmployee(@PathVariable("id") int id) {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> employees;
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from Employee e where e.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            employees = session.createQuery("from Employee").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            session.close();
        }
        return employees;
    }
}
