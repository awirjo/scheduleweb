package sr.unasat.scheduleweb.repo;


import sr.unasat.scheduleweb.dao.*;
import sr.unasat.scheduleweb.entities.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class InsertForAllService {

    BreakTimeDAO breakTimeDAO = new BreakTimeDAO();
    DepartmentDAO departmentDAO = new DepartmentDAO();
    EmployeesDAO employeesDAO = new EmployeesDAO();
    MenuDAO menuDAO = new MenuDAO();
    IdentificationDAO identificationDAO = new IdentificationDAO();

    public void insertCrudAllTables(){
        Set<Identification> identificationSet = new HashSet<>();
        Identification identification = Identification.builder().age(32).weight(65).build();
        identificationSet.add(identification);
        identificationDAO.insertIdentification(identification);

        Set<Department> departmentSet = new HashSet<>();
        Department department = Department.builder().name("ICT").regular_break("Breakfast").build();
        departmentSet.add(department);
        departmentDAO.insertDepartment(department);

        Set<Employees> employeesSet = new HashSet<>();
        Employees employees = Employees.builder().firstName("Ahmad").lastName("Golo").identification(identification).department(department).build();
        employeesSet.add(employees);
        employeesDAO.insertEmployees(employees);

        Menu menu = Menu.builder().breakfast("Cornflakes").lunch("Nasi").dinner("Lobster").special_meals("Steak with oyster sauce").description("Menu of the day").build();
        menuDAO.insertMenu(menu);

        BreakTime breakTime = BreakTime.builder().serving_time("8am").serving_date(LocalDate.now()).department(departmentSet).menu(menu).build();
        BreakTime saveBreakTime = breakTimeDAO.insertBreakTime(breakTime);
        System.out.println("The following records are inserted in the tables BreakTime, Menu, Department, Employees and Identification: " +" \n "
                + saveBreakTime + employees);
    }


}
