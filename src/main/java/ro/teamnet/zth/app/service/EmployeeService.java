package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.dao.EmployeeDao;
import ro.teamnet.zth.app.domain.Employee;

import java.util.List;

/**
 * Created by MN on 5/7/2015.
 */
public interface EmployeeService {
    List findAllEmployees();

    Employee updateEmployee(Employee employee);

    Employee findOneEmployee(int id);

    void deleteEmployee(int id);

    Employee insertEmployee(Employee employee);

}
