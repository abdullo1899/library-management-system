package uz.pdp.librarymanagementsystem.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.books.Book;
import uz.pdp.librarymanagementsystem.books.BookDao;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pageStr = req.getParameter("page");
        int page = 1;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int size = 3;

        List<Book> bookList = BookDao.getAllBooks(size, page);

        Boolean added = Boolean.valueOf(req.getParameter("added"));
        if (added) {
            req.setAttribute("message", "Successfully added!!!");
        }
        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("admin.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean added = Boolean.valueOf(req.getParameter("added"));
        if (added) {
            req.setAttribute("message", "Successfully added!!!");
        }
        req.setAttribute("bookList", BookDao.getAllBooks());
        req.getRequestDispatcher("admin.jsp").forward(req, resp);
    }
}
