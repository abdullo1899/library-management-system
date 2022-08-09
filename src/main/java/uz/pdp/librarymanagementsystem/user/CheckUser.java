package uz.pdp.librarymanagementsystem.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/checkUser")
public class CheckUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();


        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals("admin") && password.equals("1")){
            HttpSession session = req.getSession(true);
            session.setAttribute("isAuthenticated", true);
            resp.sendRedirect("/admin");
            return;
        }

        User userByUsername = UserDao.getUserByUsername(username);

        User.currentUser = userByUsername;

        if (validateUser(username, password)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("isAuthenticated", true);
            resp.sendRedirect("/books");
        } else {
            writer.println("<h1>Unable to find Student</h1>");
//            req.getRequestDispatcher("login.jsp").include(req, resp);
            resp.sendRedirect("login.jsp");
        }



    }

    private boolean validateUser(String username, String password) {
        Optional<User> userFromDb = UserDao.getList().stream().filter(user ->
                user.getUsername().equals(username) && user.getPassword().equals(password)).findFirst();
        return userFromDb.isPresent();
    }

}
