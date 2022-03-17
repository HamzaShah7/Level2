import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class main {
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
                            if (N==p.getID ()){
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
                            if (S==p.getID ()){
                                p.AddWork ();
                                System.out.println (p);
                            }
                        }
                    }
                    else {
                        System.out.println ("Your List is empty.");
                    }
                case 4:
                    System.out.print ("\nEnter text for search : ");
                    String S = sc.next();
                    Employee search = Employee.search (employees,S);
                    if(search!=null)
                        System.out.println (search.toString ());
                    else
                        System.out.println ("Result not found.");
                case 5:
                    System.out.print ("\nEnter text for search : ");
                    String searchText = sc.next();
                    Optional<Employee> employeeResult =Employee.searchPredicate(employees,searchText);
                    if(employeeResult.isPresent ())
                        System.out.println (employeeResult.toString ());
                    else
                        System.out.println ("Result not found.");



            }
        }
    }
}
