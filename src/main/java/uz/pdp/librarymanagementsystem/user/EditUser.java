package uz.pdp.librarymanagementsystem.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/edit-user")
public class EditUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        long i = Long.parseLong(id);
        List<User> userList = UserDao.getList();

        req.setAttribute("userlist", userList);
        req.setAttribute("id", i);
        req.getRequestDispatcher("/edit-user-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String id = req.getParameter("id");
        long i = Long.parseLong(id);
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = User.builder()
                .id(i)
                .fullname(fullname)
                .username(username)
                .password(password)
                .build();

        boolean update = UserDao.update(user);

        if(update){
            resp.getWriter().println("successful!!!");
            resp.sendRedirect("/students");
        }
    }
}
