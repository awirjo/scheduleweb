package sr.unasat.scheduleweb.decorator;

import sr.unasat.scheduleweb.dao.MenuDAO;
import sr.unasat.scheduleweb.entities.Menu;

public class DinnerForClosedGroup implements SpecialMeal{

    MenuDAO menuDaoGroup = new MenuDAO();
    @Override
    public void getMeal(Menu menuInsert) {
        System.out.println(" Dinner order exclusive for reserved employees: " + menuInsert.getDinner());
    }
}
