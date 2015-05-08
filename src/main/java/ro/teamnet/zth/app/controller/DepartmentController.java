package ro.teamnet.zth.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.teamnet.zth.app.dao.DepartmentDao;
import ro.teamnet.zth.app.domain.Department;

import java.util.List;

/**
 * Created by MN on 5/6/2015.
 */
@Controller
@RequestMapping(value = "/departments")
public class DepartmentController {
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Department> getAllDepartments() {
        DepartmentDao departmentDao = new DepartmentDao();
        return departmentDao.getAllDepartments();
    }

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public
    @ResponseBody
    Department getOneDepartment(@RequestParam(value = "id")String id) {
        DepartmentDao department = new DepartmentDao();

        return department.getDepartmentById(Integer.parseInt(id));
    }

}
