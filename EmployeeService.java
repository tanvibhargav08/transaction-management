package com.example.app.service;

import com.example.app.dao.EmployeeDAO;
import com.example.app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Transactional(readOnly = true)
    public Employee get(Long id) {
        return employeeDAO.get(id);
    }

    @Transactional(readOnly = true)
    public List<Employee> list() {
        return employeeDAO.list();
    }

    @Transactional
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Transactional
    public void delete(Long id) {
        employeeDAO.delete(id);
    }
}
