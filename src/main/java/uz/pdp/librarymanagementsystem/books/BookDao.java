package uz.pdp.librarymanagementsystem.books;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.pdp.librarymanagementsystem.authors.Author;
import uz.pdp.librarymanagementsystem.category.Category;
import uz.pdp.librarymanagementsystem.db.DbConnection;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookDao {

    public static List<Book> getAllBooks(int size, int page) {
        try {
            ArrayList<Book> bookList = new ArrayList<>();

//          1. CONNECTION OCHAMIZ
            Connection connection = DbConnection.getConnection();

//        2. GET PREPARED STATEMENT

            String sql = "select b.id,\n" +
                    "       b.title,\n" +
                    "       b.\"imgUrl\",\n" +
                    "       b.isbn,\n" +
                    "       b.description,\n" +
                    "       b.year,\n" +
                    "       json_agg(\n" +
                    "               json_build_object(\n" +
                    "                       'id', a.id,\n" +
                    "                       'fullName', a.fullname)) as authors,\n" +
                    "    json_build_object('id', c.id, 'name', c.name) as category\n" +
                    "--        c.id                                     as categoryId,\n" +
                    "--        c.name                                   as categoryName\n" +
                    "from book b\n" +
                    "         join books_authors ba on b.id = ba.bookid\n" +
                    "         join author a on a.id = ba.authorid\n" +
                    "         join category c on c.id = b.category_id\n" +
                    "group by b.id, c.id, c.name, b.title\n" +
                    "limit ? offset ? * (? - 1)";


            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, size);
            preparedStatement.setInt(2, page);
            preparedStatement.setInt(3, page);


//            3. GET RESULTSET

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long bookId = resultSet.getLong("id");
                String title = resultSet.getString("title");
                Array array = resultSet.getArray("authors");
                Object categoryObj = resultSet.getObject("category");
                String imgUrl = resultSet.getString("imgUrl");
                String isbn = resultSet.getString("isbn");
                int year = resultSet.getInt("year");
                String description = resultSet.getString("description");
                Type listType = new TypeToken<Set<Author>>() {
                }.getType();
                Set<Author> list = new Gson().fromJson(array.toString(), listType);

                Category category = new Gson().fromJson(categoryObj.toString(), Category.class);


                Book book = Book.builder()
                        .id(bookId)
                        .title(title)
                        .authors(list)
                        .category(category)
                        .imgUrl(imgUrl)
                        .isbn(isbn)
                        .year(year)
                        .description(description)
                        .build();

                bookList.add(book);

            }
            return bookList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Book> getAllBooks() {
        try {
            ArrayList<Book> bookList = new ArrayList<>();


//          1. CONNECTION OCHAMIZ
            Connection connection = DbConnection.getConnection();

//        2. GET PREPARED STATEMENT

            String sql = "select b.id,\n" +
                    "       b.title,\n" +
                    "       b.\"imgUrl\",\n" +
                    "       b.isbn,\n" +
                    "       b.description,\n" +
                    "       b.year,\n" +
                    "       json_agg(\n" +
                    "               json_build_object(\n" +
                    "                       'id', a.id,\n" +
                    "                       'fullName', a.fullname)) as authors,\n" +
                    "    json_build_object('id', c.id, 'name', c.name) as category\n" +
                    "--        c.id                                     as categoryId,\n" +
                    "--        c.name                                   as categoryName\n" +
                    "from book b\n" +
                    "         join books_authors ba on b.id = ba.bookid\n" +
                    "         join author a on a.id = ba.authorid\n" +
                    "         join category c on c.id = b.category_id\n" +
                    "group by b.id, c.id, c.name, b.title\n"
                    ;


            PreparedStatement preparedStatement = connection.prepareStatement(sql);




//            3. GET RESULTSET

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long bookId = resultSet.getLong("id");
                String title = resultSet.getString("title");
                Array array = resultSet.getArray("authors");
                Object categoryObj = resultSet.getObject("category");
                String imgUrl = resultSet.getString("imgUrl");
                String isbn = resultSet.getString("isbn");
                int year = resultSet.getInt("year");
                String description = resultSet.getString("description");
                Type listType = new TypeToken<Set<Author>>() {
                }.getType();
                Set<Author> list = new Gson().fromJson(array.toString(), listType);

                Category category = new Gson().fromJson(categoryObj.toString(), Category.class);


                Book book = Book.builder()
                        .id(bookId)
                        .title(title)
                        .authors(list)
                        .category(category)
                        .imgUrl(imgUrl)
                        .isbn(isbn)
                        .year(year)
                        .description(description)
                        .build();

                bookList.add(book);


            }
            return bookList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean addNewBook(Book book) {

        try {

            Connection connection = DbConnection.getConnection();

            String insertBook = "insert into book (title, \"imgUrl\", year, isbn, description, category_id) VALUES " +
                    "(?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertBook);

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getImgUrl());
            preparedStatement.setLong(3, book.getYear());
            preparedStatement.setString(4, book.getIsbn());
            preparedStatement.setString(5, book.getDescription());
            preparedStatement.setLong(6, book.getCategoryId());


            String insertBooksAuthors = "insert into books_authors VALUES ((select currval('book_id_seq')), ?)";
            PreparedStatement preparedStatement2 = connection.prepareStatement(insertBooksAuthors);

            int executeUpdate1 = preparedStatement.executeUpdate();

            int executeUpdate2 = 0;
            for (Long authorId : book.getAuthorsIds()) {
                preparedStatement2.setLong(1, authorId);
                executeUpdate2 = preparedStatement2.executeUpdate();
            }



            return executeUpdate1 == 1 && executeUpdate2 == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }


    public static Book getBookById(int id) {
        Book book = new Book();

        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("select * from book where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                book.setId(rs.getLong(1));
                book.setTitle(rs.getString(2));
                book.setImgUrl(rs.getString(3));
                book.setYear(rs.getInt(4));
                book.setIsbn(rs.getString(5));
                book.setDescription(rs.getString(6));
                book.setCategoryId(rs.getLong(7));

            }

        }catch(Exception ex){ex.printStackTrace();}

        return book;
    }


}
