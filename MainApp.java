package com.example.app;

import com.example.app.config.AppConfig;
import com.example.app.entity.Employee;
import com.example.app.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var service = context.getBean(EmployeeService.class);

        // CREATE
        Employee emp = new Employee();
        emp.setName("Alice");
        emp.setDepartment("IT");
        emp.setSalary(75000);
        service.save(emp);

        // READ
        service.list().forEach(e -> 
            System.out.println(e.getId() + " | " + e.getName())
        );

        // UPDATE
        emp.setSalary(80000);
        service.update(emp);

        // DELETE
        service.delete(emp.getId());

        context.close();
    }
}
