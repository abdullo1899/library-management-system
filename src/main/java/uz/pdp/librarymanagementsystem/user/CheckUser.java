package uz.pdp.librarymanagementsystem.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkUser")
public class CheckUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        User userByUsername = UserDao.getUserByUsername(username);

        if(username.equals("admin") && password.equals("1")){
            resp.sendRedirect("admin.jsp");
            return;
        }

        if(UserDao.checkUser(username)){
            User.currentUser = userByUsername;
//            req.getRequestDispatcher("/books").forward(req, resp);
            resp.sendRedirect("/books");
        } else {
            writer.println("<h1>Unable to find Student</h1>");
//            req.getRequestDispatcher("login.jsp").include(req, resp);
            resp.sendRedirect("login.jsp");
        }

    }
}
