package sr.unasat.scheduleweb.repo;


import sr.unasat.scheduleweb.dao.IdentificationDAO;
import sr.unasat.scheduleweb.entities.Identification;

import java.util.List;

public class IdentificationService {

    IdentificationDAO identificationDAO = new IdentificationDAO();

    public void identificationDelete(){
        System.out.println("Total identifications deleted: " + identificationDAO.deleteIdentification(70));
    }
    public void identificationUpdate(){
        Identification findIdentification = identificationDAO.findByAge(32);
        findIdentification.setAge(35);
        findIdentification.setWeight(70);
        identificationDAO.updateIdentification(findIdentification);
        System.out.println("Updated Identity: " + findIdentification);
    }
    public void identificationRetrieve(){
        List<Identification> identificationList = identificationDAO.retrieveIdentificationList();
//        identificationList.stream().forEach(System.out::println);
        System.out.println("Retrieved identification record: " + identificationList);
    }

}
