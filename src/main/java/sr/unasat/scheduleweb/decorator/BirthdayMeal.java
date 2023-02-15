package sr.unasat.scheduleweb.decorator;


import sr.unasat.scheduleweb.entities.Menu;

public class BirthdayMeal implements SpecialMeal{

    @Override
    public void getMeal(Menu menuInsert) {
        System.out.println("Birthday meal consist of:" + menuInsert.getSpecial_meals());// retrieve data from menu
    }
}
