package uz.pdp.librarymanagementsystem.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String fullname = req.getParameter("fullname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User(username, password, fullname);

        boolean add = UserDao.add(user);
        User.currentUser = UserDao.getUserByUsername(username);

        if(add){
            writer.println("<h1>Successfully saved</h1>");
            resp.sendRedirect("/books");
        } else {
            writer.println("<h1>Unable to save Record</h1>");
            req.getRequestDispatcher("register.jsp").include(req, resp);
        }


    }
}
