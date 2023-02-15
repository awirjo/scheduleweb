package sr.unasat.scheduleweb.dao;


import sr.unasat.scheduleweb.configuration.JPAConfig;
import sr.unasat.scheduleweb.entities.Department;
import sr.unasat.scheduleweb.entities.Employees;
import sr.unasat.scheduleweb.entities.Identification;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeesDAO {
    private EntityManager entityManager = JPAConfig.getEntityManager();

//    public EmployeesDAO(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
    public List<Employees> retrieveEmployeesList() {
        entityManager.getTransaction().begin();
        String jpql = "select e from Employees e";
        TypedQuery<Employees> query = entityManager.createQuery(jpql, Employees.class);
        List<Employees> employeesList = query.getResultList();
        entityManager.getTransaction().commit();
        return employeesList;
    }

    public Employees findByLastName(String lastName) {
        entityManager.getTransaction().begin();
        String jpql = "select e from Employees e  where e.lastName = :lastName";
        TypedQuery<Employees> query = entityManager.createQuery(jpql, Employees.class);
        Employees employees = query.setParameter("lastName", lastName).getSingleResult();
        entityManager.getTransaction().commit();
        return employees;
    }

    public Employees insertEmployees(Employees employees) {
        entityManager.getTransaction().begin();
        entityManager.persist(employees);
        entityManager.getTransaction().commit();
        return employees;
    }

    public int updateEmployees(Employees employees) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Employees e SET e.firstName = :firstName where e.lastName = :lastName");
        query.setParameter("firstName", employees.getFirstName());
        query.setParameter("lastName", employees.getLastName());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int deleteEmployees(String firstName) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Employees e where e.firstName = :firstName");
        query.setParameter("firstName", firstName);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
    public Employees createEmployeeAndDepartment(){
        Employees employees = Employees.builder().firstName("Mario").lastName("Luigi").
                department(Department.builder().name("ICT").build()).identification(Identification.builder().
                        age(65).weight(55).build()).build();
        entityManager.getTransaction().begin();
        entityManager.persist(employees);
        entityManager.getTransaction().commit();
        return employees;
    }
}
