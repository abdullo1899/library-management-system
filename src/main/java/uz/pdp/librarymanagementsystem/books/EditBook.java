package uz.pdp.librarymanagementsystem.books;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.authors.Author;
import uz.pdp.librarymanagementsystem.authors.AuthorDao;
import uz.pdp.librarymanagementsystem.category.Category;
import uz.pdp.librarymanagementsystem.category.CategoryDao;

import java.io.IOException;
import java.util.List;

@WebServlet("/edit-book")
public class EditBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        long i = Long.parseLong(id);
        List<Book> allBooks = BookDao.getAllBooks();
        List<Category> allCategories = CategoryDao.getAllCategories();
        List<Author> allAuthors = AuthorDao.getAllAuthors();
        req.setAttribute("booklist", allBooks);
        req.setAttribute("categoryList", allCategories);
        req.setAttribute("authorList", allAuthors);
        req.setAttribute("id", i);
        req.getRequestDispatcher("/edit-book-form.jsp").forward(req, resp);
    }


}
