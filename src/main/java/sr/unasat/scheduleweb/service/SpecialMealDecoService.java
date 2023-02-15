package sr.unasat.scheduleweb.service;

import sr.unasat.scheduleweb.dao.MenuDAO;
import sr.unasat.scheduleweb.decorator.BirthdayMeal;
import sr.unasat.scheduleweb.decorator.BirthdayParty;
import sr.unasat.scheduleweb.decorator.DinnerForClosedGroup;
import sr.unasat.scheduleweb.decorator.SpecialMeal;

public class SpecialMealDecoService {
    private MenuDAO menuDAO = new MenuDAO();

    public boolean getSpecial(){

        menuDAO.findByMealOfDay("Steak");
        menuDAO.findByDinnerGroup("Fried Noodles");

        SpecialMeal birthday = new BirthdayMeal();

        SpecialMeal dinnerForClosedGroup = new DinnerForClosedGroup();

        SpecialMeal birthdayParty = new BirthdayParty(new BirthdayMeal());

        System.out.println("Employees will get a special meal on their Birthday");
        birthday.getMeal(menuDAO.findByMealOfDay("Steak"));

        System.out.println("\n Dinner for a closed group of employees");
        dinnerForClosedGroup.getMeal(menuDAO.findByDinnerGroup("Fried Noodles"));

        System.out.println("\n ");
        birthdayParty.getMeal(menuDAO.findByMealOfDay("Steak"));
        return true;
    }
}
