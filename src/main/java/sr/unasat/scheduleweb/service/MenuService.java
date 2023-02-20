package sr.unasat.scheduleweb.service;


import sr.unasat.scheduleweb.dao.MenuDAO;
import sr.unasat.scheduleweb.entities.Menu;

import javax.persistence.EntityManager;
import java.util.List;

import static sr.unasat.scheduleweb.configuration.JPAConfig.getEntityManager;

public class MenuService {

    private static List<Menu> menuList;
    private static int menuListId;

    private MenuDAO menuDAO = new MenuDAO();
    private EntityManager entityManager = getEntityManager();

    public List<Menu> findAll(){ //get
        return menuDAO.retrieveMenuList();
    }

    public void insertMenu(Menu menuObj){ //post
        menuDAO.insertMenu(menuObj);
    }

    public Menu updateMenuInfo(int menuUpdate){ //put
        return menuDAO.findByMealById(menuUpdate);
    }

    public Menu updateMenu(Menu updatedMenu) {
        Menu existingMenu = menuDAO.findByMealById(updatedMenu.getId());
        if (existingMenu == null) {
            return null;
        }
        existingMenu.setBreakfast(updatedMenu.getBreakfast());
        existingMenu.setLunch(updatedMenu.getLunch());
        existingMenu.setDinner(updatedMenu.getDinner());
        existingMenu.setSpecial_meals(updatedMenu.getSpecial_meals());
        existingMenu.setDescription(updatedMenu.getDescription());
        entityManager.getTransaction().begin();
        entityManager.merge(existingMenu);
        entityManager.getTransaction().commit();
        return existingMenu;
    }

    public void deleteMenu(int menuDelete){ //delete
        menuDAO.deleteMenu(menuDelete);
    }

}
