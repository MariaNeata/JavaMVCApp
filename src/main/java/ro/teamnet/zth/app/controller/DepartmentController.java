package ro.teamnet.zth.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.teamnet.zth.app.domain.Department;
import ro.teamnet.zth.app.service.DepartmentService;
import ro.teamnet.zth.app.service.DepartmentServiceImpl;

import java.util.List;

/**
 * Created by MN on 5/6/2015.
 */
@Controller
@RequestMapping(value = "/departments")
public class DepartmentController {
    private DepartmentService department = new DepartmentServiceImpl();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Department> getAllDepartments() {
        return department.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Department getOneDepartment(@PathVariable("id") Integer idDepartment) {
        return department.findOne(idDepartment);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Department create(@RequestBody Department d) {
        return this.department.create(d);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody Department update(@RequestBody Department d) {
        return this.department.update(d);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable("id") Integer idDepartment) {
        department.delete(idDepartment);
    }

}
