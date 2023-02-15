package sr.unasat.scheduleweb.factory;

import sr.unasat.scheduleweb.entities.Department;
import sr.unasat.scheduleweb.entities.Employees;

public class Delivery extends Order{
    private Employees employees;
    private Department department;

    public Delivery(Employees employees, Department department) {
        this.employees = employees;
        this.department = department;
    }

    @Override
    public String getOrder() {

        return "Order delivery for: " + this.employees.getLastName() + " at Department: " + this.department.getName();
    }

}
