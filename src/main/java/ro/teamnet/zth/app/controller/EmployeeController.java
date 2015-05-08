package ro.teamnet.zth.app.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.teamnet.zth.app.dao.EmployeeDao;
import ro.teamnet.zth.app.domain.Employee;
import ro.teamnet.zth.app.service.EmployeeServiceImpl;

import java.util.List;

/**
 * Created by MN on 5/6/2015.
 */
@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Employee> getAllEmployees() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        return employeeService.findAllEmployees();
    }

    @RequestMapping(value = "/{idEmployee}", method = RequestMethod.GET)
    public
    @ResponseBody
    Employee getOneEmployee(@PathVariable("idEmployee") String idEmployee) {
        EmployeeServiceImpl employee = new EmployeeServiceImpl();
        return employee.findOneEmployee(Integer.parseInt(idEmployee));

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteOneEmployee(@PathVariable("id") String id) {
        EmployeeServiceImpl employee = new EmployeeServiceImpl();
        employee.deleteEmployee(Integer.parseInt(id));
    }


    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    Employee addNewEmployee(@RequestBody Employee employee) {
        EmployeeServiceImpl e = new EmployeeServiceImpl();
        return e.insertEmployee(employee);

    }

    @RequestMapping(method = RequestMethod.PUT)
    public
    @ResponseBody
    Employee updateEmployee(@RequestBody Employee employee) {
        EmployeeServiceImpl e = new EmployeeServiceImpl();
        return e.updateEmployee(employee);

    }
}
