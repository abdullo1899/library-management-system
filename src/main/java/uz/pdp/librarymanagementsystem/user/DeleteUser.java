package uz.pdp.librarymanagementsystem.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete-user")
public class DeleteUser extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid=req.getParameter("id");
        long id = Long.parseLong(sid);

        UserDao.delete(id);
        resp.sendRedirect("/students");
    }
}
