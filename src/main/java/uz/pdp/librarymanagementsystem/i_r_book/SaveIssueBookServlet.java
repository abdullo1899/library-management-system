package uz.pdp.librarymanagementsystem.i_r_book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.books.BookDao;
import uz.pdp.librarymanagementsystem.user.UserDao;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/save-issue-book")
public class SaveIssueBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("userList", UserDao.getList());
        req.setAttribute("bookList", BookDao.getAllBooks());
        req.getRequestDispatcher("save-issue-book.jsp").forward(req, resp);
    }

    protected static Set<Long> getBookIdsFromStrArr(String[] bookIds) {
        Set<Long> bookIdsLong = new HashSet<>();
        for (String bookId : bookIds) {
            bookIdsLong.add(Long.parseLong(bookId));
        }
        return bookIdsLong;
    }
}
