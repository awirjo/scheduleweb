package sr.unasat.scheduleweb.dao;

import sr.unasat.scheduleweb.entities.Department;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

import static sr.unasat.scheduleweb.configuration.JPAConfig.getEntityManager;

public class DepartmentDAO {
    private EntityManager entityManager = getEntityManager();

//    public DepartmentDAO(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
    public List<Department> retrieveDepartmentList() {
        entityManager.getTransaction().begin();
        String jpql = "select d from Department d";
        TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
        List<Department> departmentList = query.getResultList();
        entityManager.getTransaction().commit();
        return departmentList;
    }

    public Department findByDepartmentInfo(String name) {
        entityManager.getTransaction().begin();
        String jpql = "select d from Department d  where d.name = :name";
        TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
        Department department = query.setParameter("name", name).getSingleResult();
        entityManager.getTransaction().commit();
        return department;
    }

    public Department insertDepartment(Department department) {
        entityManager.getTransaction().begin();
        entityManager.persist(department);
        entityManager.getTransaction().commit();
        return department;
    }

    public int updateDepartment(Department department) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Department d SET d.name = :name where d.regular_break = :regular_break");
        query.setParameter("name", department.getName());
        query.setParameter("regular_break", department.getRegular_break());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int deleteDepartmentBreak(String regular_break) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Department d where d.regular_break = :regular_break");
        query.setParameter("regular_break", regular_break);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
    public Department findByDepartmentEmployee(String employeeName) {
        entityManager.getTransaction().begin();
        String jpql = "select d from Department d  join d.employees em where em.firstName = :firstName";
        TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
        Department department = query.setParameter("firstName", employeeName).getSingleResult();
        entityManager.getTransaction().commit();
        return department;
    }
    public boolean verifyDepartmentByEmployee(String employeeName) {
        entityManager.getTransaction().begin();
        String jpql = "select d from Department d  join d.employees em where em.firstName = :firstName";
        TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
        Department department = query.setParameter("firstName", employeeName).getSingleResult();
        entityManager.getTransaction().commit();
        if(department != null){
            return true;
        }else{
            return false;
        }
    }
    public List<Department> getDepartmentInfo(String idNumber) {
        entityManager.getTransaction().begin();
        String jpql = "select d from Department d where d.employees = :idNumber";
        TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
        query.setParameter("idNumber", idNumber);
        List<Department> departmentList = query.getResultList();
        entityManager.getTransaction().commit();
        return departmentList;
    }

    public Department findByDepartment(String name) {
        try {
            entityManager.getTransaction().begin();
            String jpql = "select d from Department d where d.name = :name";
            TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
            Department department = query.setParameter("name", name).getSingleResult();
            entityManager.getTransaction().commit();
            return department;
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }



}
