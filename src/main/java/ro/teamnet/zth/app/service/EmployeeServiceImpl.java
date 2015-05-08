package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.dao.EmployeeDao;
import ro.teamnet.zth.app.domain.Employee;

import java.util.List;

/**
 * Created by MN on 5/7/2015.
 */
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List findAllEmployees() {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.getAllEmployees();
    }

    public Employee findOneEmployee(int id) {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.getEmployeeById(id);
    }

    public void deleteEmployee(int id) {
        EmployeeDao employee = new EmployeeDao();

        employee.deleteEmployee(employee.getEmployeeById(id));
    }

    public Employee insertEmployee(Employee employee) {
        EmployeeDao e = new EmployeeDao();
        return e.insertEmployee(employee);
    }

    public Employee updateEmployee(Employee employee) {
        EmployeeDao e = new EmployeeDao();
        return e.updateEmployee(employee);

    }
}
