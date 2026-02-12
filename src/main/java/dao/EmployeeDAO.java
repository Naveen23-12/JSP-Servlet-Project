package dao;

import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM employee")) {

            while (rs.next()) {
                Employee e = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("department"),
                    rs.getDouble("salary")
                );
                list.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean addEmployee(Employee e) {
        String sql = "INSERT INTO employee (name, email, department, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getDepartment());
            ps.setDouble(4, e.getSalary());

            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Employee getEmployeeById(int id) {
        Employee e = null;
        String sql = "SELECT * FROM employee WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("department"),
                    rs.getDouble("salary")
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public boolean updateEmployee(Employee e) {
        String sql = "UPDATE employee SET name=?, email=?, department=?, salary=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getDepartment());
            ps.setDouble(4, e.getSalary());
            ps.setInt(5, e.getId());

            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
