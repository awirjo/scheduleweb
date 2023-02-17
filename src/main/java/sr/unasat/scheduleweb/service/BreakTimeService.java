package sr.unasat.scheduleweb.service;

import sr.unasat.scheduleweb.dao.BreakTimeDAO;
import sr.unasat.scheduleweb.entities.BreakTime;
import sr.unasat.scheduleweb.entities.Menu;

import java.util.List;

public class BreakTimeService {

    private BreakTimeDAO breakTimeDAO = new BreakTimeDAO();

    public List<BreakTime> findAllBreakTime(){
        return breakTimeDAO.retrieveBreakTimeList();
    }

    public void insertBreakTime(BreakTime breakTimeObj){ //post
        breakTimeDAO.insertBreakTime(breakTimeObj);
    }
    public BreakTime updateBreakTime(int breakTimeUpdate){ //put
        return breakTimeDAO.findBreakTimeById(breakTimeUpdate);
    }

    public void deleteBreakTime(String breakTimeDelete){ //delete
        breakTimeDAO.deleteBreakTimeMeal(breakTimeDelete);
    }
}
