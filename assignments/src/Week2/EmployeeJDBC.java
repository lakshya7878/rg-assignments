package Week2;

import java.sql.*;


public class EmployeeJDBC {
    public static class Employee{
        public int id;
        public String name;
        public String department;

        public Employee(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }
    }
    private static Connection conn = null;

    public static void setupConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstDb", "root", "myPassword");
            System.out.println("Successfully connected!");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createEmployee(Employee emp) {
        String sql = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        try(PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, emp.id);
            statement.setString(2, emp.name);
            statement.setString(3, emp.department);
            statement.executeUpdate();
            System.out.println("Row added successfully");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readEmployee(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try(PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                System.out.println("Employee details : \n" + "id : " + id);
                System.out.println("name : " + rs.getString("name"));
                System.out.println("department : " + rs.getString("department"));
            }
            else{
                System.out.println("No employee with id : " + id + " was found");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  void updateEmployee(Employee emp) {
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, emp.name);
            statement.setString(2, emp.department);
            statement.setInt(3, emp.id);
            statement.executeUpdate();

            System.out.println("Data updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();

            System.out.println("Successfully deleted employee with id : " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        setupConnection();

        // Create
        Employee emp1 = new Employee(1,"Lakshya Sharma", "Software Engineering");
        createEmployee(emp1);

        Employee emp2 = new Employee(2,"Lucky", "Finance");
        createEmployee(emp2);

        // Read (find employee with a specific id)
        readEmployee(2);

        // Update
        emp2.name = "Lucky Sharma";
        updateEmployee(emp2);

        // Delete
        deleteEmployee(2);

        closeConnection();
    }
}


