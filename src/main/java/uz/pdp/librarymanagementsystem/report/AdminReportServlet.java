package uz.pdp.librarymanagementsystem.report;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.books.BookDao;
import uz.pdp.librarymanagementsystem.i_r_book.I_R_Dao;
import uz.pdp.librarymanagementsystem.user.UserDao;

import java.io.IOException;

@WebServlet("/admin-reports")
public class AdminReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("userlist", UserDao.getList());
        req.setAttribute("list", I_R_Dao.getList());
        req.setAttribute("booklist", BookDao.getAllBooks());
        req.getRequestDispatcher("admin-reports.jsp").forward(req, resp);
    }
}
