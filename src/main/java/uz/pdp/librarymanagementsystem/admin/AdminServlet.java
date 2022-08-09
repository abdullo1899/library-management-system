package uz.pdp.librarymanagementsystem.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.books.BookDao;

import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean added = Boolean.valueOf(req.getParameter("added"));
        if (added) {
            req.setAttribute("message", "Successfully added!!!");
        }
        req.setAttribute("bookList", BookDao.getAllBooks());
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
