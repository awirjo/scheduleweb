package sr.unasat.scheduleweb.service;

import sr.unasat.scheduleweb.configuration.JPAConfig;
import sr.unasat.scheduleweb.dao.BreakTimeDAO;
import sr.unasat.scheduleweb.dto.BreakTimeDTO;
import sr.unasat.scheduleweb.entities.BreakTime;
import sr.unasat.scheduleweb.entities.Department;
import sr.unasat.scheduleweb.entities.Menu;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BreakTimeService {

    private BreakTimeDAO breakTimeDAO = new BreakTimeDAO();
    private EntityManager entityManager = JPAConfig.getEntityManager();

    public List<BreakTime> findAllBreakTime(){
        return breakTimeDAO.retrieveBreakTimeList();
    }

    public BreakTime createBreakTime(BreakTimeDTO breakTimeDTO) {

        BreakTime breakTime = new BreakTime();
        try {
            Menu menu = entityManager.find(Menu.class, breakTimeDTO.getMenu().getId());

            Set<Department> departments = new HashSet<>();
            for (Department department : breakTimeDTO.getDepartment()) {
                Department dbDepartment = entityManager.find(Department.class, department.getId());
                departments.add(dbDepartment);
            }

            breakTime.setMenu(menu);
            breakTime.setDepartment(departments);
            breakTime.setServing_time(breakTimeDTO.getServing_time());
            breakTime.setServing_date(breakTimeDTO.getServing_date());
            breakTimeDAO.insertBreakTime(breakTime);

            return breakTime;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return breakTime;

    }

    public BreakTime updateBreakTime(int breakTimeUpdate){ //put
        return breakTimeDAO.findBreakTimeById(breakTimeUpdate);
    }

    public void deleteBreakTime(int breakTimeDelete){ //delete
        breakTimeDAO.deleteBreakTime(breakTimeDelete);
    }

}
