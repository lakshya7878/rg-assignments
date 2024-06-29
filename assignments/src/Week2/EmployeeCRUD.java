package Week2;

import java.util.ArrayList;

class Employee{
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department){
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public void setId(int value){
        this.id = value;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getName(){
        return this.name;
    }

    public void setDepartment(String value){
        this.department = value;
    }

    public String getDepartment(){
        return this.department;
    }
}


public class EmployeeCRUD {
    public static ArrayList<Employee> employees = new ArrayList<>();

    public static void createEmployee(Employee emp){
        employees.add(emp);
    }

    public static void  readEmployee(int id){
        for(int i = 0;i<employees.size();i++){
            if(employees.get(i).getId() == id){
                System.out.println("Employee details : \n");
                System.out.println("name, department: " + employees.get(i).getName() + ", "+ employees.get(i).getDepartment());
                return;
            }
        }
        System.out.println("No such employee found");
    }

    public static void updateEmployee(Employee emp){
        for(int i = 0;i<employees.size();i++){
            if(employees.get(i).getId() == emp.getId()){
                employees.get(i).setId(emp.getId());
                employees.get(i).setName(emp.getName());
                employees.get(i).setDepartment(emp.getDepartment());
                return;
            }
        }
    }

    public static void deleteEmployee(int id){
        for(int i = 0;i<employees.size();i++){
            if(employees.get(i).getId() == id){
                employees.remove(i);
                return;
            }
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Lakshya", "Software Engineering");
        Employee emp2 = new Employee(2, "Judo Sloth", "HR and Finance");

        // Create :
        createEmployee(emp1);
        createEmployee(emp2);

        // Read :
        readEmployee(2);

        // Update :
        emp2.setName("Aditya Sharma");
        updateEmployee(emp2);

        // Delete :
        deleteEmployee(2);

    }
}
