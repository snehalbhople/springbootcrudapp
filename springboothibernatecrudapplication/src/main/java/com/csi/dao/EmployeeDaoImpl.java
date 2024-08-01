package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import javax.sound.midi.Track;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public void save(Employee employee) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
    }

    @Override
    public void saveAll(List<Employee> employeeList) {
        Session session = factory.openSession();
        for (Employee employee : employeeList) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }

    }

    @Override
    public Employee findById(int empId) {
        Session session = factory.openSession();
        return (Employee) session.load(Employee.class, empId);
    }

    @Override
    public List<Employee> findAll() {
        Session session = factory.openSession();
        return session.createQuery("from Employee").list();
    }

    @Override
    public void update(int empId, Employee employee) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee1 = findById(empId);

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());

        session.update(employee1);
        transaction.commit();

    }

    @Override
    public void deleteById(int empId) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = findById(empId);
        session.delete(employee);
        transaction.commit();

    }

    @Override
    public void deleteAll() {
        Session session = factory.openSession();
        for (Employee employee : findAll()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();


        }
    }
}
