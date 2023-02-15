package sr.unasat.scheduleweb.factory;


import sr.unasat.scheduleweb.entities.Employees;

public class TakeOut extends Order{

    private Employees employees;

    public TakeOut(Employees employees) {
        this.employees = employees;
    }

    @Override
    public String getOrder() {
        return "Order takeout for: " + this.employees.getLastName();

    }
}
