package uz.pdp.librarymanagementsystem.authors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/authors")
public class ViewAuthor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        List<Author> list = AuthorDao.getAllAuthors();

        for (Author author : list) {
            if(i == author.getId()){
              resp.sendRedirect("https://en.wikipedia.org/w/index.php?search=" + author.getFullName());
            }
        }
    }
}
