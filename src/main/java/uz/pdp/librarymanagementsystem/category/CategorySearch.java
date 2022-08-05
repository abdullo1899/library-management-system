package uz.pdp.librarymanagementsystem.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.books.Book;
import uz.pdp.librarymanagementsystem.books.BookDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/category-search")
public class CategorySearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("id");
        int i = Integer.parseInt(id);

        List<Book> allBooks = BookDao.getAllBooks();

        for (Book book : allBooks) {
            if(i == book.getCategory().getId()){
                writer.println("<img src="+book.getImgUrl()+"class=\"card-img-top\" alt="+ book.getTitle() + "><br><br>"
                        + book.getTitle() + "<br><br>");
            }
        }
    }
}


