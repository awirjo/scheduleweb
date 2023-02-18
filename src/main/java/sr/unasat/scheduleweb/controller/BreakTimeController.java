package sr.unasat.scheduleweb.controller;

import sr.unasat.scheduleweb.configuration.JPAConfig;
import sr.unasat.scheduleweb.dao.BreakTimeDAO;
import sr.unasat.scheduleweb.dao.DepartmentDAO;
import sr.unasat.scheduleweb.dao.MenuDAO;
import sr.unasat.scheduleweb.entities.BreakTime;
import sr.unasat.scheduleweb.entities.Department;
import sr.unasat.scheduleweb.entities.Menu;
import sr.unasat.scheduleweb.service.BreakTimeService;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.stream.Collectors;

@Path("breakTime")

public class BreakTimeController {

    private BreakTimeService breakTimeService = new BreakTimeService();
    private BreakTimeDAO breakTimeDAO = new BreakTimeDAO();
    private EntityManager entityManager = JPAConfig.getEntityManager();

    @PersistenceContext(unitName = "PERSISTENCE")

    @Path("breakList")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BreakTime> findBreak(){
        System.out.println(breakTimeService.findAllBreakTime());
        return breakTimeService.findAllBreakTime();
    }

    @Path("/addBreak")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public BreakTime createBreakTime(BreakTime breakTime, int menuId, List<Long> departmentIds) {
        try {
            Menu menu = entityManager.find(Menu.class, menuId);

            Set<Department> departments = new HashSet<>();
            for (Long id : departmentIds) {
                Department department = entityManager.find(Department.class, id);
                departments.add(department);
            }

            breakTime.setMenu(menu);
            breakTime.setDepartment(departments);
            breakTimeDAO.addBreakTime(breakTime, menuId, departmentIds);

            return breakTime;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding BreakTime data: " + e.getMessage());
        }
    }







}
