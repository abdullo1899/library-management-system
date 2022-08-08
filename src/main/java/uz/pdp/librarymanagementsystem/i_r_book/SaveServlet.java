package uz.pdp.librarymanagementsystem.i_r_book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@WebServlet("/save-i_r-book")
public class SaveServlet extends HttpServlet {
    public static String[] bookIds = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String is_issued = req.getParameter("is_issued");
        bookIds = req.getParameterValues("bookIds");
        Set<Long> bookIdsFromlongArr = SaveIssueBookServlet.getBookIdsFromStrArr(bookIds);
        String id = req.getParameter("id");
        long l = Long.parseLong(id);

        if(is_issued.equals("true")){
            I_R_book i_r_book = I_R_book.builder()
                    .books(bookIdsFromlongArr)
                    .date(Date.valueOf(LocalDate.now()))
                    .is_issued(true)
                    .student_id(l)
                    .build();

            boolean result = I_R_Dao.add(i_r_book);

            if (result) {
                writer.println("Successfully added!!!");
                req.getRequestDispatcher("/save-issue-book").include(req, resp);
            }
        } else if (is_issued.equals("false")){

            boolean result = false;

            result = I_R_Dao.updateR_Book(l);

            if (result) {
                writer.println("Successfully added!!!");
                req.getRequestDispatcher("save-issue-book.jsp").include(req, resp);
            }
        }

    }
}
