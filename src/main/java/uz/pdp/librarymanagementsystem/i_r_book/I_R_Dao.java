package uz.pdp.librarymanagementsystem.i_r_book;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.pdp.librarymanagementsystem.db.DbConnection;

import java.awt.print.Book;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class I_R_Dao {

    public static boolean add(I_R_book i_r_book) {
        try (
                Connection connection = DbConnection.getConnection();
                PreparedStatement preparedStatement
                        = connection
                        .prepareStatement("insert into issued_returned_books(date, is_issued, student_id, book_id) values (?,?,?,?)")
        ) {


            preparedStatement.setDate(1, (Date) i_r_book.getDate());
            preparedStatement.setBoolean(2, i_r_book.getIs_issued());
            preparedStatement.setLong(3, i_r_book.getStudent_id());

            int executeUpdate1 = 0;
            for (Long book_id : i_r_book.getBooks()) {
                preparedStatement.setLong(4, book_id);
                executeUpdate1 = preparedStatement.executeUpdate();
            }



            return executeUpdate1 == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

    public static List<I_R_book> getList() {
        List<I_R_book> i_r_bookList = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {


            ResultSet resultSet
                    = statement.executeQuery("select i.id, " +
                    "i.date, " +
                            "i.is_issued,\n" +
                            "u.id,\n" +
                            "json_agg(\n" +
                            "               json_build_object(\n" +
                            "                       'id', b.id,\n" +
                            "                       'fullName', b.title)) as books\n" +
                    "from issued_returned_books i\n" +
                            "join book b on b.id = i.book_id\n" +
                            "join users u on i.student_id = u.id\n" +
                            " group by i.is_issued, i.date, i.id\n"
                    );
            while (resultSet.next()) {

                Long id = resultSet.getLong("id");
                boolean is_issued = resultSet.getBoolean("is_issued");
                Date date = resultSet.getDate("date");
                Long student_id = resultSet.getLong("student_id");
                Array array = resultSet.getArray("books");
                Type listType = new TypeToken<Set<Book>>() {
                }.getType();
                Set<uz.pdp.librarymanagementsystem.books.Book> list = new Gson().fromJson(array.toString(), listType);

                I_R_book i_r_book = I_R_book.builder()
                        .id(id)
                        .date(date)
                        .book_ids(list)
                        .student_id(student_id)
                        .build();

            }
            return i_r_bookList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
