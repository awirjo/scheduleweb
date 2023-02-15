package sr.unasat.scheduleweb.service;

import sr.unasat.scheduleweb.dao.DepartmentDAO;
import sr.unasat.scheduleweb.dao.EmployeesDAO;
import sr.unasat.scheduleweb.factory.Order;
import sr.unasat.scheduleweb.factory.OrderFactory;
import sr.unasat.scheduleweb.factory.OrderType;

public class DeliveryFactoryService {

    public boolean deliveryService(){
        EmployeesDAO employeesDAO = new EmployeesDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();

        Order takeOut = OrderFactory.getOrderType(OrderType.TAKEOUT, employeesDAO.findByLastName("Golo"), departmentDAO.findByDepartment("ICT"));
        Order delivery = OrderFactory.getOrderType(OrderType.DELIVERY,employeesDAO.findByLastName("Golo"), departmentDAO.findByDepartment("ICT"));
        System.out.println(takeOut.getOrder());
        System.out.println(delivery.getOrder());
        return true;
    }
}
