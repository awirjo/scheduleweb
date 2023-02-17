package sr.unasat.scheduleweb.controller;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Path("breakTime")

public class BreakTimeController {

    private BreakTimeService breakTimeService = new BreakTimeService();
    private MenuDAO menuDAO = new MenuDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();

    private BreakTimeDAO breakTimeDAO = new BreakTimeDAO();

    @PersistenceContext(unitName = "PERSISTENCE")
    private EntityManager entityManager;
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

    public BreakTime createBreakTime(BreakTime breakTime) {
        Menu menu = entityManager.find(Menu.class, breakTime.getMenu().getId());
        Set<Department> departments = new HashSet<>();
        for (Department department : breakTime.getDepartment()) {
            departments.add(entityManager.find(Department.class, department.getId()));
        }
        breakTime.setMenu(menu);
        breakTime.setDepartment(departments);
        entityManager.getTransaction().begin();
        entityManager.persist(breakTime);
        entityManager.getTransaction().commit();
        return breakTime;
    }

    @Path("/removeBreak")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(String breakTime){
        breakTimeService.deleteBreakTime(breakTime);
    }

    @Path("/getBreak")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BreakTime getBreakTime(int breakTimeId){
        return breakTimeService.updateBreakTime(breakTimeId);
    }


}
