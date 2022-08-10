package uz.pdp.librarymanagementsystem.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class UserViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");
        int page = 1;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int size = 10;

        List<User> list = UserDao.getList(size, page);

        req.setAttribute("list", list);
        req.getRequestDispatcher("students.jsp").forward(req, resp);

    }
}
