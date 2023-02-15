package sr.unasat.scheduleweb.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import sr.unasat.scheduleweb.configuration.JPAConfig;
import sr.unasat.scheduleweb.repo.*;
import sr.unasat.scheduleweb.service.BreakTimeService;
import sr.unasat.scheduleweb.service.MenuService;

public class Application {
    public static void main(String[] args) {


        //Insert all tables
        InsertForAllService insertForAllService = new InsertForAllService();
//        insertForAllService.insertCrudAllTables();

        //BreakTime service
        BreakTimeServiceRepo breakTimeService = new BreakTimeServiceRepo();
//        breakTimeService.breakTimeRetrieve();
//        breakTimeService.breakTimeUpdate();
//        breakTimeService.breakTimeDelete();
//        breakTimeService.breakTimeRapportByQuarter();
//        breakTimeService.breakTimeRapportHalfYear();
//        breakTimeService.breakTimeRapportByYear();

        //Department service
        DepartmentService departmentService = new DepartmentService();
//        departmentService.departmentRetrieve();
//        departmentService.departmentInsert();
//        departmentService.departmentUpdate();
//        departmentService.departmentDelete();


        //Employees service
        EmployeesService employeesService = new EmployeesService();
//        employeesService.employeesRetrieve();
//        employeesService.employeesUpdate();
//        employeesService.employeesDelete();

        //IdentificationService service
        IdentificationService identificationService = new IdentificationService();
//        identificationService.identificationRetrieve();
//        identificationService.identificationUpdate();
//        identificationService.identificationDelete();

        //Menu service
        MenuServiceRepo menuServiceRepo = new MenuServiceRepo();
//        menuServiceRepo.menuRetrieve();
//        menuServiceRepo.menuUpdate();
//        menuServiceRepo.menuDelete();

//        //Factory
        OrderFactoryService orderFactoryService = new OrderFactoryService();
//        insertForAllService.insertCrudAllTables();
//        orderFactoryService.orderApplication();

//        //Decorator
        SpecialMealDecoratorService specialMealDecoratorService = new SpecialMealDecoratorService();
//        specialMealDecoratorService.specialApplication();

        //chain of responsibilities
//        menuServiceRepo.menuInsertHrmMenu();
//        menuServiceRepo.menuInsertMiningMenu();
        MessageChainMakerService messageChainMaker = new MessageChainMakerService();
//        messageChainMaker.messageMaker();


        JPAConfig.shutdown();

    }
}
