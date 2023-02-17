package sr.unasat.scheduleweb.controller;

import sr.unasat.scheduleweb.entities.BreakTime;
import sr.unasat.scheduleweb.entities.Department;
import sr.unasat.scheduleweb.entities.Menu;
import sr.unasat.scheduleweb.service.BreakTimeService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("breakTime")
public class BreakTimeController {

    private BreakTimeService breakTimeService = new BreakTimeService();
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
    public void addBreakTime(BreakTime breakTime) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
//        Menu menu = entityManager.find(Menu.class, breakTime.getMenu().getId());
        Menu menu = null;
        if (breakTime.getMenu() != null) {
            menu = entityManager.find(Menu.class, breakTime.getMenu().getId());
        }

        breakTime.setMenu(menu);
        Set<Department> departments = new HashSet<>();
        for (Department department : breakTime.getDepartment()) {
            Department d = entityManager.find(Department.class, department.getId());
            departments.add(d);
        }
        breakTime.setDepartment(departments);
        entityManager.persist(breakTime);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

}

    public void add(BreakTime breakTime){
        breakTimeService.insertBreakTime(breakTime);
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
