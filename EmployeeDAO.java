package com.example.app.dao;

import com.example.app.entity.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Employee employee) {
        sessionFactory.getCurrentSession().persist(employee);
    }

    public Employee get(Long id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    public List<Employee> list() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Employee", Employee.class)
                .list();
    }

    public void update(Employee employee) {
        sessionFactory.getCurrentSession().merge(employee);
    }

    public void delete(Long id) {
        Employee emp = get(id);
        if (emp != null) {
            sessionFactory.getCurrentSession().remove(emp);
        }
    }
}
