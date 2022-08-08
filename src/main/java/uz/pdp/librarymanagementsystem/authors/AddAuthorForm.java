package uz.pdp.librarymanagementsystem.authors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add-author")
public class AddAuthorForm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("fullname");
        String biography = req.getParameter("biography");
        Author author = Author.builder()
                .fullName(name)
                .biography(biography)
                .build();
        boolean b = AuthorDao.addAuthor(author);

        if(b){
            resp.sendRedirect("/admin?added=true");
        }
    }
}
