import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;


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
        double Sal = getSalary ();
        if (Sal<500){
            setSalary (Sal+10);
        }
    }

    public void AddWork(){
        double hour = getHours ();
        if (hour>6){
            setSalary (getSalary ()+5);
        }
    }

    public static void main (String[] args) {

        ArrayList<Employee> employees = new ArrayList<> ();
        Scanner sc = new Scanner (System.in);
        int letter = 5;
        //int Emp_No = (int) (Math.random()*(999-100+1)+100);
        int Emp_No = 100;
        while(letter!=0){
            if (employees.isEmpty ()){
                System.out.println ("Enter Employee Details");
                letter = 1;
            }
            else {
                System.out.print ("Enter 0 to Exit\nEnter 1 to Add New Employee\nEnter 2 to Add $10 to Salary \nEnter 3 to Add $5 to Salary\nEnter 4 to Show Employee Details. ");
                letter = sc.nextInt ();
            }
            switch (letter){
                case 1:
                    System.out.print ("Enter Your Name: ");
                    String Name = sc.next ();
                    System.out.print ("Enter Your Salary: ");
                    double Salary = sc.nextDouble ();
                    System.out.print ("Enter Your Hours: ");
                    float Hours = sc.nextFloat ();
                    Employee employee = new Employee ();
                    Emp_No = Emp_No + 1;
                    employees.add (employee.getInfo (Emp_No,Name,Salary,Hours));
                    break;

                case 2:
                    if (!(employees.isEmpty ())){
                        for (Employee p : employees){
                            System.out.println (p);
                        }
                        System.out.print ("Enter Your ID: ");
                        int N = sc.nextInt ();
                        for (Employee p : employees){
                            if (N==p.ID){
                                p.AddSal ();
                                System.out.println (p);
                            }
                        }
                    }
                    else {
                        System.out.println ("Your list is empty");
                    }
                    break;

                case 3:
                    if (!(employees.isEmpty ())){
                        System.out.print ("Enter Your ID: ");
                        int S = sc.nextInt ();
                    for (Employee p : employees){
                            if (S==p.ID){
                                p.AddWork ();
                                System.out.println (p);
                            }
                        }
                    }
                    else {
                        System.out.println ("Your List is empty.");
                    }
                case 4:
                    System.out.print ("Enter Your ID: ");
                    int S = sc.nextInt ();
                    for (Employee p : employees){
                        if (S==p.ID){
                            System.out.println (p);
                        }
                    }
                    break;
            }
        }
    }
}


