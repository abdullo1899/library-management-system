package uz.pdp.librarymanagementsystem.user;

import uz.pdp.librarymanagementsystem.db.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao {
    public static boolean add(User user) {
        try (
                Connection connection = DbConnection.getConnection();
                PreparedStatement preparedStatement
                        = connection
                        .prepareStatement("insert into users(fullname, password, username) values (?,?,?)")
        ) {


            preparedStatement.setString(1, user.getFullname());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.execute();


            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }


    public static List<User> getList() {
        List<User> userList = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {


            ResultSet resultSet
                    = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                User user = new User();
                user.get(resultSet);
                userList.add(user);
            }
            return userList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static boolean update(User user) {
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement(
                    "update users set username=?,password=?,fullname=? where id=?");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getFullname());
            ps.setInt(4,user.getId());
            ps.execute();

        }catch(Exception ex){ex.printStackTrace(); return false;}

        return true;
    }


    public static boolean delete(int id) {

        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("delete from users where id=?");
            ps.setInt(1,id);
            ps.execute();

        }catch(Exception e){e.printStackTrace(); return false;}

        return true;
    }


    public static User getUserByUsername(String  username) {
        User user =new User();

        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("select * from users where username=?");
            ps.setString(1,username);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFullname(rs.getString(4));
            }

        }catch(Exception ex){ex.printStackTrace();}

        return user;
    }

    public static boolean checkUser(String username) {
        Optional<User> userFromDb = UserDao.getList().stream().filter(user ->
                user.getUsername().equals(username)).findAny();
        return userFromDb.isPresent();
    }


}
