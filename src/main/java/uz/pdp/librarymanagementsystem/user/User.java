package uz.pdp.librarymanagementsystem.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.librarymanagementsystem.books.Book;
import uz.pdp.librarymanagementsystem.db.Base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Base {
   public static User currentUser = null;
    private Integer id;
    private String username;
    private String password;
    private String fullname;

    private Set<Long> bookIds;
    private Set<Book> books;

    public User(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

    public void get(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("id");
            this.username = resultSet.getString("username");
            this.password = resultSet.getString("password");
            this.fullname = resultSet.getString("fullname");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
