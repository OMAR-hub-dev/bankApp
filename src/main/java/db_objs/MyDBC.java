package db_objs;

import java.math.BigDecimal;
import java.sql.*;

public class MyDBC {
    // database configurations
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bankapp";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    public  static User valideteLogin(String username, String password){
        try {
            // establish a connection to the database using configurations
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            // create sql query
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username =? AND password =?"
            );
            // replace the ? with values
            // parameter index referring to the iteration of the ? so 1 is the first ? and 2 is the second ?
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,password);

            // execute query and store into a result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // next() returns true or false
            // true - query returned data and result set now points to the first row
            // false - query returned no data and result set equals to null
            if (resultSet.next()){
                int userId = resultSet.getInt("id");
                BigDecimal currentBalance = resultSet.getBigDecimal("current_balance");

//                return User Object
                return new User(userId, username, password, currentBalance);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  null;
    }

}
