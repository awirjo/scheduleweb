package sr.unasat.scheduleweb.repo;

import sr.unasat.scheduleweb.dao.DepartmentDAO;
import sr.unasat.scheduleweb.entities.Department;

import java.util.List;

public class DepartmentService {

    DepartmentDAO departmentDAO = new DepartmentDAO();

    public void departmentDelete(){
        System.out.println("Total departments deleted: " + departmentDAO.deleteDepartmentBreak("Lunch"));
}
    public void departmentUpdate(){
        Department findDepartment = departmentDAO.findByDepartment("ICT");
        findDepartment.setName("Mining");
        findDepartment.setRegular_break("Dinner");
        departmentDAO.updateDepartment(findDepartment);
        System.out.println("The following records are updated: " + findDepartment);
    }

    public void departmentRetrieve(){
        List<Department> departmentList = departmentDAO.retrieveDepartmentList();
//        departmentList.stream().forEach(System.out::println);
        System.out.println("Retrieved department record: " + departmentList);
    }

    public void departmentInsert(){
        Department department = Department.builder().name("Hrm").regular_break("Lunch").build();
        departmentDAO.insertDepartment(department);
        System.out.println("Hrm Department is inserted");
    }
}
