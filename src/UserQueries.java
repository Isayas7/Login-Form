import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserQueries {

    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String USER = "root";
    private static final String PASSWORD = "possible";

    private static Connection connection;
    private static PreparedStatement psInsert;
    private static PreparedStatement SelectAll;

    ObservableList<User> list = FXCollections.observableArrayList();

    UserQueries() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            psInsert = connection.prepareStatement(
                    "INSERT INTO userinfo  (fname, mname, lname, gender, phoneNumber, email, password) VALUES(?, ?, ?, ?, ?, ?, ?)");
            SelectAll = connection.prepareStatement("Select * from userinfo");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int addUser(String fname, String mname, String lname, String gender,
            String phoneNumber, String email, String password) throws SQLException {
        psInsert.setString(1, fname);
        psInsert.setString(2, mname);
        psInsert.setString(3, lname);
        psInsert.setString(4, gender);
        psInsert.setString(5, phoneNumber);
        psInsert.setString(6, email);
        psInsert.setString(7, password);

        return psInsert.executeUpdate();
    }

    public int config(String email, String password) {
        try (ResultSet resultSet = SelectAll.executeQuery()) {
            int returned = 0;
            while (resultSet.next()) {
                if (resultSet.getString(6).equals(email) && resultSet.getString(7).equals(password)) {
                    returned = 1;
                    break;
                } else {
                    returned = 0;
                }

            }
            return returned;
        } catch (Exception e) {
            return 0;
        }
    }

    public void closeCon() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}