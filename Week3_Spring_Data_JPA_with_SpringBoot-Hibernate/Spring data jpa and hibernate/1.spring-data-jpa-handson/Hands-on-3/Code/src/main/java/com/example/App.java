// App.java
package com.example;

import com.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");  // Looks for the config file

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Employee emp = new Employee();
        emp.setName("Sweeny Todd");
        emp.setSalary(70000);

        session.save(emp); // Save to DB

        tx.commit(); // Finalize transaction
        session.close();
        factory.close();

        System.out.println("Employee inserted successfully");
    }
}
