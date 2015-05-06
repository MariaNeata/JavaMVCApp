package ro.teamnet.zth.app.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by MN on 5/6/2015.
 */
@MyController(urlPath = "/departments")
public class DepartmentController {
    @MyRequestMethod(urlPath = "/all")
    public String getAllDepartments() {
        return "all Departments";
    }

    @MyRequestMethod(urlPath = "/one")
    public String getOneDepartment() {
        return "oneRandomDepartment";
    }

}
