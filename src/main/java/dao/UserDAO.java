package dao;

import java.sql.*;

public class UserDAO {
    public boolean validate(String username, String password) {
        boolean status = false;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?")) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
