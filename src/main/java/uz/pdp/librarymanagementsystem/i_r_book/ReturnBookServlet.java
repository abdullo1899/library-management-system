package uz.pdp.librarymanagementsystem.i_r_book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.user.User;

import java.io.IOException;
import java.util.List;


@WebServlet("/return-book")
public class ReturnBookServlet extends HttpServlet {
    public static String[] bookIds = null;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<I_R_book> list = I_R_Dao.getList();
        req.setAttribute("list", list);
        req.setAttribute("user", User.currentUser);
        req.getRequestDispatcher("return-book.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         bookIds = req.getParameterValues("bookIds");
        boolean result = false;

            result = I_R_Dao.updateR_Book(User.currentUser.getId());

        if (result) {
            resp.sendRedirect("/books?added=true");
        }
    }
}
