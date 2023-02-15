package sr.unasat.scheduleweb.repo;

import sr.unasat.scheduleweb.dao.BreakTimeDAO;
import sr.unasat.scheduleweb.dao.MenuDAO;
import sr.unasat.scheduleweb.entities.BreakTime;
import sr.unasat.scheduleweb.entities.Menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BreakTimeServiceRepo {

    BreakTimeDAO breakTimeDAO = new BreakTimeDAO();
    MenuDAO menuDAO = new MenuDAO();
    Menu menu = new Menu();
    BreakTime breakTime = new BreakTime();

    public void breakTimeUpdate(){
        BreakTime findBreakTime = breakTimeDAO.findByServingTime("8am");
        Menu menuUpdate = Menu.builder().breakfast("Brood ei").lunch("Bami").dinner("Mac&Cheese").description("Menu of the day").special_meals("Cake").build();
        menuDAO.insertMenu(menuUpdate);
        findBreakTime.setMenu(menuUpdate);
        breakTimeDAO.updateBreakTime(findBreakTime);
        System.out.println("The following records are updated: " + findBreakTime.getMenu());
    }

    public void breakTimeRetrieve(){
        List<BreakTime> breakTimeSelect = breakTimeDAO.retrieveBreakTimeList();
//        breakTimeSelect.stream().forEach(System.out::println);
        System.out.println("Retrieved record Break Time: " + "\n" + breakTimeSelect);
    }

    public void breakTimeDelete(){
        BreakTime deletedBreakTime = breakTimeDAO.findByServingTime("8am");
        breakTimeDAO.deleteBreakTimeMeal("From 8am till 7pm");
        System.out.println("The following records are deleted: " + deletedBreakTime);
    }
    public void breakTimeRapportByQuarter(){
        List<BreakTime> breakTimeSelectRapport = breakTimeDAO.findServingDateByQuarter(LocalDate.parse("2021-02-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(breakTimeSelectRapport);
    }
    public void breakTimeRapportHalfYear(){
        List<BreakTime> breakTimeSelectRapport = breakTimeDAO.findServingDateByHalfYear(LocalDate.parse("2021-02-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(breakTimeSelectRapport);
    }
    public void breakTimeRapportByYear(){
        List<BreakTime> breakTimeSelectRapport = breakTimeDAO.findDateByYear(LocalDate.parse("2021-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(breakTimeSelectRapport);
    }



}
