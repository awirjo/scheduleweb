package sr.unasat.scheduleweb.service;

import sr.unasat.scheduleweb.dao.BreakTimeDAO;
import sr.unasat.scheduleweb.entities.BreakTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportsService {

    BreakTimeDAO breakTimeDAO = new BreakTimeDAO();
    public List<BreakTime> breakTimeRapportByQuarter(){
        List<BreakTime> breakTimeQuarterRapport = breakTimeDAO.findServingDateByQuarter(LocalDate.parse("2021-02-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(breakTimeQuarterRapport);
        return breakTimeQuarterRapport;
    }
    public List<BreakTime> breakTimeRapportHalfYear(){
        List<BreakTime> breakTimeHalfYearRapport = breakTimeDAO.findServingDateByHalfYear(LocalDate.parse("2021-02-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(breakTimeHalfYearRapport);
        return breakTimeHalfYearRapport;
    }
    public List<BreakTime> breakTimeRapportByYear(){
        List<BreakTime> breakTimeYearRapport = breakTimeDAO.findDateByYear(LocalDate.parse("2021-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(breakTimeYearRapport);
        return breakTimeYearRapport;
    }

}
