package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.domain.Department;

import java.util.List;

/**
 * Created by MN on 5/8/2015.
 */
public interface DepartmentService {
    List<Department> findAll();
    Department findOne(Integer idDepartment);

    Department create(Department department);

    Department update(Department department);

    void delete(Integer idDepartment);
}
