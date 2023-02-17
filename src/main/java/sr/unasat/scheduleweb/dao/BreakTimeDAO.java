package sr.unasat.scheduleweb.dao;


import com.fasterxml.jackson.databind.ObjectMapper;
import sr.unasat.scheduleweb.configuration.JPAConfig;
import sr.unasat.scheduleweb.entities.BreakTime;
import sr.unasat.scheduleweb.entities.Department;
import sr.unasat.scheduleweb.entities.Employees;
import sr.unasat.scheduleweb.entities.Menu;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class BreakTimeDAO {
    private EntityManager entityManager = JPAConfig.getEntityManager();
    private MenuDAO menuDAO = new MenuDAO();
    private EmployeesDAO employeesDAO = new EmployeesDAO();


//    public BreakTimeDAO(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    public List<BreakTime> findServingDateByHalfYear(LocalDate serving_date) {
        entityManager.getTransaction().begin();
        String jpql = "select b from BreakTime b join Menu m on b.menu.id = m.id where QUARTER(b.serving_date) in (1,2) and m.description =:description";
        TypedQuery<BreakTime> query = entityManager.createQuery(jpql, BreakTime.class);
        List<BreakTime> breakTimeList = query.setParameter("description", "Meal of the day").getResultList();
        entityManager.getTransaction().commit();
        return breakTimeList;
    }
    public List<BreakTime> findServingDateByYear(LocalDate serving_date) {
        entityManager.getTransaction().begin();
        String jpql = "select b from BreakTime b where b.serving_date = :serving_date and YEAR(b.serving_date) =:year";
        TypedQuery<BreakTime> query = entityManager.createQuery(jpql, BreakTime.class);
        List<BreakTime> breakTimeList = query.setParameter("serving_date", serving_date).setParameter("year", serving_date.getYear()).getResultList();
        entityManager.getTransaction().commit();
        return breakTimeList;
    }
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


    public BreakTime createBreakTime(BreakTime breakTime) {
        entityManager.getTransaction().begin();
        entityManager.persist(breakTime);
        entityManager.getTransaction().commit();
        return breakTime;
    }
}
