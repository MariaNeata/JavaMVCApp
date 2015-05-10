package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.dao.DepartmentDao;
import ro.teamnet.zth.app.domain.Department;

import java.util.List;

/**
 * Created by MN on 5/8/2015.
 */
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao = new DepartmentDao();

    @Override
    public List<Department> findAll() {
        return departmentDao.getAllDepartments();
    }

    @Override
    public Department findOne(Integer idDepartment) {
        return departmentDao.getDepartmentById(idDepartment);
    }

    @Override
    public Department create(Department department) {
        return departmentDao.insertDepartment(department);
    }

    @Override
    public Department update(Department department) {
        return departmentDao.updateDepartment(department);
    }

    @Override
    public void delete(Integer idDepartment) {
        Department department = departmentDao.getDepartmentById(idDepartment);
        departmentDao.deleteDepartment(department);
    }

}
