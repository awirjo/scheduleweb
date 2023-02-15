package sr.unasat.scheduleweb.repo;

import sr.unasat.scheduleweb.dao.*;
import sr.unasat.scheduleweb.entities.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuServiceRepo {

    BreakTimeDAO breakTimeDAO = new BreakTimeDAO();
    DepartmentDAO departmentDAO = new DepartmentDAO();
    EmployeesDAO employeesDAO = new EmployeesDAO();
    MenuDAO menuDAO = new MenuDAO();
    IdentificationDAO identificationDAO = new IdentificationDAO();

    public void menuDelete() {
        System.out.println("Menu deleted: " + menuDAO.deleteMenu(2));
    }

    public void menuUpdate() {
        Menu findMenu = menuDAO.findByMealOfDay("Steak with oyster sauce");
        findMenu.setSpecial_meals("Seafood boil platter");
        findMenu.setDescription("Updated menu of the day");
        findMenu.setBreakfast("Toasted bread with scrambled eggs");
        findMenu.setLunch("Fried Rice with Chicken");
        findMenu.setDinner("Shrimp pasta");
        menuDAO.updateMenu(findMenu);
        System.out.println("Updated menu: " + findMenu);
    }

    public void menuRetrieve() {
        List<Menu> menuList = menuDAO.retrieveMenuList();
//        menuList.stream().forEach(System.out::println);
        System.out.println("Retrieved the menu record: " + menuList);
    }

    public void menuInsertHrmMenu() {
        Set<Identification> identificationSet = new HashSet<>();
        Identification identification = Identification.builder().age(32).weight(65).build();
        identificationSet.add(identification);
        identificationDAO.insertIdentification(identification);

        Set<Department> departmentSet = new HashSet<>();
        Department department = Department.builder().name("Hrm").regular_break("Lunch").build();
        departmentSet.add(department);
        departmentDAO.insertDepartment(department);

        Set<Employees> employeesSet = new HashSet<>();
        Employees employees = Employees.builder().firstName("Jordi").lastName("Alba").identification(identification).department(department).build();
        employeesSet.add(employees);
        employeesDAO.insertEmployees(employees);

        Menu menu = Menu.builder().breakfast("Waffle").lunch("Fried Rice").dinner("Fried Noodles").special_meals("Ribeye steak").description("Menu of the day").build();
        menuDAO.insertMenu(menu);

        BreakTime breakTime = BreakTime.builder().serving_time("From 9am till 9pm").serving_date(LocalDate.now()).department(departmentSet).menu(menu).build();
        BreakTime saveBreakTime = breakTimeDAO.insertBreakTime(breakTime);
    }

    public void menuInsertMiningMenu() {
        Set<Identification> identificationSet = new HashSet<>();
        Identification identification = Identification.builder().age(32).weight(65).build();
        identificationSet.add(identification);
        identificationDAO.insertIdentification(identification);

        Set<Department> departmentSet = new HashSet<>();
        Department department = Department.builder().name("Mining").regular_break("Dinner").build();
        departmentSet.add(department);
        departmentDAO.insertDepartment(department);

        Set<Employees> employeesSet = new HashSet<>();
        Employees employees = Employees.builder().firstName("Frenkie").lastName("De Jong").identification(identification).department(department).build();
        employeesSet.add(employees);
        employeesDAO.insertEmployees(employees);

        Menu menu = Menu.builder().breakfast("Porridge").lunch("Dumplings").dinner("Teryaki Chicken").special_meals("Pasta Shrimp").description("Menu of the day").build();
        menuDAO.insertMenu(menu);

        BreakTime breakTime = BreakTime.builder().serving_time("From 11am till 10pm").serving_date(LocalDate.now()).department(departmentSet).menu(menu).build();
        BreakTime saveBreakTime = breakTimeDAO.insertBreakTime(breakTime);

    }
}
