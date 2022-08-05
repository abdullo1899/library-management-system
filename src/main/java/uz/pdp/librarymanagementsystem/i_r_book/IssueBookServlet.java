package uz.pdp.librarymanagementsystem.i_r_book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.books.BookDao;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/issue-book")
public class IssueBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bookList", BookDao.getAllBooks());
        req.getRequestDispatcher("issue-book.jsp").forward(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] bookIds = req.getParameterValues("bookIds");

        Set<Long> bookIdsFromlongArr = getBookIdsFromStrArr(bookIds);

        I_R_book i_r_book = I_R_book.builder()
                .books(bookIdsFromlongArr)
                .date(Date.valueOf(LocalDate.now()))
                .is_issued(true)
                .build();

        boolean result = I_R_Dao.add(i_r_book);

        if (result) {
            resp.sendRedirect("/books?added=true");
        }
    }

    private Set<Long> getBookIdsFromStrArr(String[] bookIds) {
        Set<Long> bookIdsLong = new HashSet<>();
        for (String bookId : bookIds) {
            bookIdsLong.add(Long.parseLong(bookId));
        }
        return bookIdsLong;
    }
}
