package sr.unasat.scheduleweb.service;

import sr.unasat.scheduleweb.dao.BreakTimeDAO;
import sr.unasat.scheduleweb.entities.BreakTime;
import sr.unasat.scheduleweb.entities.Menu;

import javax.persistence.EntityManager;
import java.util.List;

public class BreakTimeService {

    private BreakTimeDAO breakTimeDAO = new BreakTimeDAO();

    public List<BreakTime> findAllBreakTime(){
        return breakTimeDAO.retrieveBreakTimeList();
    }

//    public BreakTime getBreakTimeById(long id) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        try {
//            BreakTime breakTime = entityManager.find(BreakTime.class, id);
//            if (breakTime == null) {
//                return null; // or throw an exception, depending on your requirements
//            }
//
//            // Load the associated Menu object for the BreakTime
//            Menu menu = breakTime.getMenu();
//            if (menu != null) {
//                menu = entityManager.find(Menu.class, menu.getId());
//                breakTime.setMenu(menu);
//            }
//
//            return breakTime;
//        } finally {
//            entityManager.close();
//        }
//    }

    public BreakTime updateBreakTime(int breakTimeUpdate){ //put
        return breakTimeDAO.findBreakTimeById(breakTimeUpdate);
    }

    public void deleteBreakTime(String breakTimeDelete){ //delete
        breakTimeDAO.deleteBreakTimeMeal(breakTimeDelete);
    }
}
