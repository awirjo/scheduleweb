package sr.unasat.scheduleweb.service;


import sr.unasat.scheduleweb.dao.MenuDAO;
import sr.unasat.scheduleweb.entities.Menu;

import java.util.List;

public class MenuService {

    private static List<Menu> menuList;
    private static int menuListId;

//    public MenuService(){
//        if (menuList == null) {
//            menuListId = 0;
//            menuList = new ArrayList<>();
//            menuList.add(new Menu(++menuListId));
//        }
//    }

    private MenuDAO menuDAO = new MenuDAO();

    public List<Menu> findAll(){ //get
        return menuDAO.retrieveMenuList();
    }

    public void insertMenu(Menu menuObj){ //post
        menuDAO.insertMenu(menuObj);
    }

    public Menu updateMenu(int menuUpdate){ //put
        return menuDAO.findByMealById(menuUpdate);
    }

    public void deleteMenu(int menuDelete){ //delete
        menuDAO.deleteMenu(menuDelete);
    }

}
