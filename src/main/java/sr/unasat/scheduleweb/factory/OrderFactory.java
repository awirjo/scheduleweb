package sr.unasat.scheduleweb.factory;


import sr.unasat.scheduleweb.entities.Department;
import sr.unasat.scheduleweb.entities.Employees;

public class OrderFactory {
    public static Order getOrderType(OrderType orderType, Employees employees, Department department){

        switch (orderType){
            case TAKEOUT:
                return new TakeOut(employees);
            case DELIVERY:
                return new Delivery(employees, department);
        }
        return null;
    }

}
