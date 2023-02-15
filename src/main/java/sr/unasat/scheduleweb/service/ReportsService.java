package sr.unasat.scheduleweb.service;

import sr.unasat.scheduleweb.dao.BreakTimeDAO;
import sr.unasat.scheduleweb.entities.BreakTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportsService {

    BreakTimeDAO breakTimeDAO = new BreakTimeDAO();
    public boolean breakTimeRapportByQuarter(){
        List<BreakTime> breakTimeSelectRapport = breakTimeDAO.findServingDateByQuarter(LocalDate.parse("2021-02-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(breakTimeSelectRapport);
        return true;
    }
    public boolean breakTimeRapportHalfYear(){
        List<BreakTime> breakTimeSelectRapport = breakTimeDAO.findServingDateByHalfYear(LocalDate.parse("2021-02-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(breakTimeSelectRapport);
        return true;
    }
    public boolean breakTimeRapportByYear(){
        List<BreakTime> breakTimeSelectRapport = breakTimeDAO.findDateByYear(LocalDate.parse("2021-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(breakTimeSelectRapport);
        return true;
    }

}
