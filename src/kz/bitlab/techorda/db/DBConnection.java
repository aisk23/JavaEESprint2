package kz.bitlab.techorda.db;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    private static Connection data;
    public static boolean correct = true;
    public static boolean login = false;

    public static boolean isCorrect() {
        return correct;
    }

    public static void setCorrect(boolean correct) {
        DBConnection.correct = correct;
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            data = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/orda_db",
                    "root",
                    "");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Users getUser(String login){
        Users user = null;
        try {
            PreparedStatement statement = data.prepareStatement(
                    "SELECT * FROM login where email = ?");
            statement.setString(1, login);
            ResultSet set = statement.executeQuery();

            while (set.next()){
                user = new Users();
                user.setId(set.getInt("id"));
                user.setEmail(set.getString("email"));
                user.setPassword(set.getString("password"));
                user.setFullName(set.getString("full_name"));
            }
            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }


    public static ArrayList<Items> getItems(){
        ArrayList<Items> items = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = data.prepareStatement(
                    "SELECT * FROM Items");
            ResultSet set = preparedStatement.executeQuery();

            while (set.next()){
                Items item = new Items();
                item.setId(set.getInt("id"));
                item.setName(set.getString("name"));
                item.setDescription(set.getString("description"));
                item.setPrice(set.getDouble("price"));
                items.add(item);
            }
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return items;
    }

    public static boolean isLogin() {
        return login;
    }

    public static void setLogin(boolean login) {
        DBConnection.login = login;
    }
}