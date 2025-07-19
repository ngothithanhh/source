package dao;

import database.JDBCUtil;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public boolean register(User user){
        String sql = "insert into Users(username, password) values(?,?)";
        try{
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            return ps.executeUpdate() > 0;
        }
        catch (SQLException e){
            return false;
        }
    }

    public boolean login(String username, String password){
        String sql = "select * from Users where username = ? and password = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean changePassword(String username, String oldPassword, String newPassword) {
        String sql = "UPDATE Users SET password = ? WHERE username = ? AND password = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newPassword);     // cập nhật mật khẩu mới
            ps.setString(2, username);        // theo đúng username
            ps.setString(3, oldPassword);     // chỉ đổi nếu mật khẩu cũ đúng

            return ps.executeUpdate() > 0;    // true nếu có dòng được cập nhật
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAccount(String username, String password){
        String sql = "delete from Users where username = ? and password = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

}
