package sr.unasat.scheduleweb.dao;

import sr.unasat.scheduleweb.configuration.JPAConfig;
import sr.unasat.scheduleweb.entities.BreakTime;
import sr.unasat.scheduleweb.entities.Department;
import sr.unasat.scheduleweb.entities.Menu;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

public class BreakTimeDAO {
    private EntityManager entityManager = JPAConfig.getEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    @PersistenceContext(unitName = "PERSISTENCE")
    private EntityManager entityManagerPersistence;
    private MenuDAO menuDAO = new MenuDAO();
    private EmployeesDAO employeesDAO = new EmployeesDAO();
    private DepartmentDAO departmentDAO = new DepartmentDAO();

    public List<BreakTime> findServingDateByHalfYear(LocalDate serving_date) {
        entityManager.getTransaction().begin();
        String jpql = "select b from BreakTime b join Menu m on b.menu.id = m.id where QUARTER(b.serving_date) in (1,2) and m.description =:description";
        TypedQuery<BreakTime> query = entityManager.createQuery(jpql, BreakTime.class);
        List<BreakTime> breakTimeList = query.setParameter("description", "Meal of the day").getResultList();
        entityManager.getTransaction().commit();
        return breakTimeList;
    }
//    public List<BreakTime> findServingDateByYear(LocalDate serving_date) {
//        entityManager.getTransaction().begin();
//        String jpql = "select b from BreakTime b where b.serving_date = :serving_date and YEAR(b.serving_date) =:year";
//        TypedQuery<BreakTime> query = entityManager.createQuery(jpql, BreakTime.class);
//        List<BreakTime> breakTimeList = query.setParameter("serving_date", serving_date).setParameter("year", serving_date.getYear()).getResultList();
//        entityManager.getTransaction().commit();
//        return breakTimeList;
//    }
    public List<BreakTime> findDateByYear(LocalDate serving_date) {
        entityManager.getTransaction().begin();
        String jpql = "select b from BreakTime b join Menu m on b.menu.id = m.id where QUARTER(b.serving_date) in (1,2,3,4) and m.description =: description";
        TypedQuery<BreakTime> query = entityManager.createQuery(jpql, BreakTime.class);
        List<BreakTime> breakTimeList = query.setParameter("description", "Meal of the day").getResultList();
        entityManager.getTransaction().commit();
        return breakTimeList;
    }
    public List<BreakTime> findServingDateByQuarter(LocalDate serving_date) {
        entityManager.getTransaction().begin();
        String jpql = "select b from BreakTime b join Menu m on b.menu.id = m.id where QUARTER(b.serving_date) in (1) and m.description =:description";
        TypedQuery<BreakTime> query = entityManager.createQuery(jpql, BreakTime.class);
        List<BreakTime> breakTimeList = query.setParameter("description", "Meal of the day").getResultList();
        entityManager.getTransaction().commit();
        return breakTimeList;
    }
//    public List<BreakTime> findServingDateByQuarter(LocalDate serving_date) {
//        entityManager.getTransaction().begin();
//        String jpql = "select b from BreakTime b where b.serving_date = :serving_date and QUARTER(b.serving_date) =:quarter";
//        TypedQuery<BreakTime> query = entityManager.createQuery(jpql, BreakTime.class);
//        List<BreakTime> breakTimeList = query.setParameter("serving_date", "Menu of the day").setParameter("quarter", 1).getResultList();
//        entityManager.getTransaction().commit();
//        return breakTimeList;
//    }

    public List<BreakTime> retrieveBreakTimeList() {
        entityManager.getTransaction().begin();
        String jpql = "select b from BreakTime b";
        TypedQuery<BreakTime> query = entityManager.createQuery(jpql, BreakTime.class);
        List<BreakTime> breakTimeList = query.getResultList();
        entityManager.getTransaction().commit();
        return breakTimeList;
    }

    public BreakTime findByServingTime(String serving_time) {
        entityManager.getTransaction().begin();
        String jpql = "select b from BreakTime b  where b.serving_time = :serving_time";
        TypedQuery<BreakTime> query = entityManager.createQuery(jpql, BreakTime.class);
        BreakTime breakTime = query.setParameter("serving_time", serving_time).getSingleResult();
        entityManager.getTransaction().commit();
        return breakTime;
    }

    public BreakTime insertBreakTime(BreakTime breakTime) {
        entityManager.getTransaction().begin();
        entityManager.persist(breakTime);
        entityManager.getTransaction().commit();
        return breakTime;
    }

    public int updateBreakTime(BreakTime breakTime) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE BreakTime b SET b.serving_time = :serving_time where b.serving_date = :serving_date");
        query.setParameter("serving_time", breakTime.getServing_time());
        query.setParameter("serving_date", breakTime.getServing_date());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int deleteBreakTimeMeal(String serving_time) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from BreakTime b where b.serving_time = :serving_time");
        query.setParameter("serving_time", serving_time);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
    public int deleteBreakTime(int id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from BreakTime b where b.id = :id");
        query.setParameter("id", id);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

    public List<BreakTime> findBreakTimeByDepartment(Department departmentFind) {
        entityManager.getTransaction().begin();
        String jpql = "select b from BreakTime b  where b.department = :department";
        TypedQuery<BreakTime> query = entityManager.createQuery(jpql, BreakTime.class);
        List<BreakTime> breakTimeList = query.setParameter("department", departmentFind).getResultList();
        entityManager.getTransaction().commit();
        return breakTimeList;
    }

    public BreakTime findBreakTimeById(int breakTimeId) {
        entityManager.getTransaction().begin();
        String jpql = "select b from BreakTime b  where b.id = :id";
        TypedQuery<BreakTime> query = entityManager.createQuery(jpql, BreakTime.class);
        BreakTime breakTime = query.setParameter("id", breakTimeId).getSingleResult();
        entityManager.getTransaction().commit();
        return breakTime;
    }

    public void addBreakTime(BreakTime breakTime, int menuId, List<Long> departmentIds) {
        try {
            transaction.begin();

            if (breakTime != null) {
                // Add the BreakTime object itself
                entityManagerPersistence.persist(breakTime);

                // Then, retrieve the Menu object  ID and set it in the BreakTime object
                Menu menu = entityManagerPersistence.find(Menu.class, menuId);
                breakTime.setMenu(menu);

                // Retrieve the Department objects IDs and add to the BreakTime object
                List<Department> departments = new ArrayList<>();
                for (Long id : departmentIds) {
                    Department department = entityManagerPersistence.find(Department.class, id);
                    departments.add(department);
                }
                breakTime.setDepartment(new HashSet<>(departments));

                transaction.commit();
            } else {
                throw new IllegalArgumentException("BreakTime object cannot be null.");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManagerPersistence.close();
        }
    }
    public BreakTime insertOneRecord(BreakTime breakTime) {
        Set<Department> departments = new HashSet<>();
        for (Department department : breakTime.getDepartment()) {
            Department d = departmentDAO.findByDepartment(department.getName());
            if (d == null) {
                throw new IllegalArgumentException("Department not found");
            }
            departments.add(d);
        }
        Menu menu = menuDAO.findMenuByDescription(breakTime.getMenu().getDescription());
        if (menu == null) {
            throw new IllegalArgumentException("Menu not found");
        }
        entityManager.getTransaction().begin();
        try {
            breakTime.setDepartment(departments);
            breakTime.setMenu(menu);
            entityManager.persist(breakTime);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Error inserting record", e);
        } finally {
            entityManager.close();
        }
        return breakTime;
    }






}
