package sr.unasat.scheduleweb.dao;

import sr.unasat.scheduleweb.entities.Menu;

import javax.persistence.*;
import java.util.List;

import static sr.unasat.scheduleweb.configuration.JPAConfig.getEntityManager;

public class MenuDAO {
    private EntityManager entityManager = getEntityManager();
    public List<Menu> retrieveMenuList() {
        entityManager.getTransaction().begin();
        String jpql = "select m from Menu m";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        List<Menu> menuList = query.getResultList();
        entityManager.getTransaction().commit();
        return menuList;
    }

    public Menu findByMealOfDay(String special_meals) {
        entityManager.getTransaction().begin();
        String jpql = "select m from Menu m  where m.special_meals = :special_meals";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu menu = query.setParameter("special_meals", special_meals).getSingleResult();
        entityManager.getTransaction().commit();
        return menu;
    }
    public Menu findByMealById(int menuId) {
        entityManager.getTransaction().begin();
        String jpql = "select m from Menu m  where m.id = :id";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu menu = query.setParameter("id", menuId).getSingleResult();
        entityManager.getTransaction().commit();
        return menu;
    }

    public Menu findByDinnerGroup(String dinner) {
        entityManager.getTransaction().begin();
        String jpql = "select m from Menu m  where m.dinner = :dinner";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu menu = query.setParameter("dinner", dinner).getSingleResult();
        entityManager.getTransaction().commit();
        return menu;
    }
    public Menu findByMealForIct(String breakfast) {
        entityManager.getTransaction().begin();
        String jpql = "select m from Menu m  where m.breakfast = :breakfast";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu menu = query.setParameter("breakfast", breakfast).getSingleResult();
        entityManager.getTransaction().commit();
        return menu;
    }
    public Menu findByMealForHrm(String lunch) {
        entityManager.getTransaction().begin();
        String jpql = "select m from Menu m  where m.lunch = :lunch";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu menu = query.setParameter("lunch", lunch).getSingleResult();
        entityManager.getTransaction().commit();
        return menu;
    }
    public Menu findByMealForMining(String dinner) {
        entityManager.getTransaction().begin();
        String jpql = "select m from Menu m  where m.dinner = :dinner";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        Menu menu = query.setParameter("dinner", dinner).getSingleResult();
        entityManager.getTransaction().commit();
        return menu;
    }

    public Menu insertMenu(Menu menu) {
        entityManager.getTransaction().begin();
        entityManager.merge(menu);
        entityManager.getTransaction().commit();
        return menu;
    }
    public Menu insertMenuChain(Menu menuChain) {
        entityManager.getTransaction().begin();
        entityManager.persist(menuChain);
        entityManager.getTransaction().commit();
        return menuChain;
    }

    public int deleteMenu(int id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Menu m where m.id = :id");
        query.setParameter("id", id);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
    public Menu find(int id) {
        entityManager.getTransaction().begin();
        Menu menu = entityManager.find(Menu.class, id);
        entityManager.getTransaction().commit();
        return menu;
    }
    public Menu findMenuByDescription(String description) throws PersistenceException {
        try {
            entityManager.getTransaction().begin();
            String jpql = "select m from Menu m where m.description = :description";
            TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
            query.setParameter("description", description);
            Menu menu = query.getSingleResult();
            entityManager.getTransaction().commit();
            return menu;
        } catch (NoResultException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("No menu found with description: " + description);
        } catch (NonUniqueResultException e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Multiple menus found with description: " + description);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new PersistenceException("Error finding menu by description: " + description, e);
        }
    }
    public List<Menu> getMenuInfo() {
        entityManager.getTransaction().begin();
        String jpql = "select m from Menu m";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        List<Menu> menuList = query.getResultList();
        entityManager.getTransaction().commit();
        return menuList;
    }



}
