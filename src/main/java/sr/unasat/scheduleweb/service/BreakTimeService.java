package sr.unasat.scheduleweb.service;

import sr.unasat.scheduleweb.dao.BreakTimeDAO;
import sr.unasat.scheduleweb.entities.BreakTime;

import java.util.List;

public class BreakTimeService {

    private BreakTimeDAO breakTimeDAO = new BreakTimeDAO();

    public List<BreakTime> findAllBreakTime(){
        return breakTimeDAO.retrieveBreakTimeList();
    }
}
