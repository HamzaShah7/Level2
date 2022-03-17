import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;


public class Employee {
    private int ID;
    private String name;
    private double salary;
    private double hours;

    public Employee(){
    }


    public String getName () {
        return name;
    }

    public double getHours () {
        return hours;
    }

    public double getSalary () {
        return salary;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setHours (double hours) {
        this.hours = hours;
    }

    public void setSalary (double salary) {
        this.salary = salary;
    }

    public int getID () {
        return ID;
    }

    public void setID (int ID) {
        this.ID = ID;
    }

    @Override
    public String toString () {
        return "ID:" + getID ()  + "\tName:" + getName () + "\tSalary:" + getSalary () +
                "\tHours:" + getHours ();
    }

    public Employee getInfo(int ID,String name,double salary, double hours){
        this.setID (ID);
        this.setName (name);
        this.setSalary (salary);
        this.setHours (hours);
        return this;
    }

    public void AddSal(){
        if (getSalary ()<500){
            setSalary (getSalary ()+10);
        }
        else {
            System.out.println ("Your Salary is greater than $500.");
        }
    }

    public void AddWork(){
        if (getHours ()>6){
            setSalary (getSalary ()+5);
        }
        else {
            System.out.println ("Your worked less than 6 hours.");
        }
    }

    public static Employee search(ArrayList<Employee> employees, String search)
    {
        for (Employee employee: employees) {
            if(Double.toString(employee.getSalary()).equals (search) || employee.getName ().equals (search))
                return employee;
        }
    return null;
    }


    public static Optional<Employee> searchPredicate(ArrayList<Employee> employees,String search)
    {

        Predicate<Employee> isName = employee -> employee.getName ().equalsIgnoreCase (search);
        Predicate<Employee> isSalary = employee -> Double.toString(employee.getSalary ()).equalsIgnoreCase (search);
        return employees.stream().filter (isName.or(isSalary)).findFirst();

    }

}
