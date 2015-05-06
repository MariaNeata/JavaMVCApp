package ro.teamnet.zth.app.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by MN on 5/6/2015.
 */
@MyController(urlPath = "/employees")
public class EmployeeController {

    @MyRequestMethod(urlPath = "/all")
    public String getAllEmployees() {
        String allEmployees = "employees";
        return allEmployees;
    }
    @MyRequestMethod(urlPath = "/one")
    public String getOneEmployee() {
        return "oneRandomEmployee";
    }
}
