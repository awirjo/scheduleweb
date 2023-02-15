package sr.unasat.scheduleweb.dao;

import sr.unasat.scheduleweb.configuration.JPAConfig;
import sr.unasat.scheduleweb.entities.Identification;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class IdentificationDAO {
    private EntityManager entityManager = JPAConfig.getEntityManager();

//    public IdentificationDAO(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
    public List<Identification> retrieveIdentificationList() {
        entityManager.getTransaction().begin();
        String jpql = "select i from Identification i";
        TypedQuery<Identification> query = entityManager.createQuery(jpql, Identification.class);
        List<Identification> identificationList = query.getResultList();
        entityManager.getTransaction().commit();
        return identificationList;
    }

    public Identification findByAge(Integer age) {
        entityManager.getTransaction().begin();
        String jpql = "select i from Identification i  where i.age = :age";
        TypedQuery<Identification> query = entityManager.createQuery(jpql, Identification.class);
        Identification identification = query.setParameter("age", age).getSingleResult();
        entityManager.getTransaction().commit();
        return identification;
    }

    public Identification insertIdentification(Identification identification) {
        entityManager.getTransaction().begin();
        entityManager.persist(identification);
        entityManager.getTransaction().commit();
        return identification;
    }

    public int updateIdentification(Identification identification) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Identification i SET i.age = :age where i.weight = :weight");
        query.setParameter("age", identification.getAge());
        query.setParameter("weight", identification.getWeight());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int deleteIdentification(Integer weight) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Identification i where i.weight = :weight");
        query.setParameter("weight", weight);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
}
