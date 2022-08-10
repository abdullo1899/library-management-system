package uz.pdp.librarymanagementsystem.books;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.Set;

import static uz.pdp.librarymanagementsystem.books.AddBookServlet.uploadAndGetImageUrl;

@WebServlet("/edit")
@MultipartConfig(maxFileSize = 10_000_000)

public class EditBook2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        long l = Long.parseLong(id);
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String[] authorsIdsStr = req.getParameterValues("authorsIds");

        Set<Long> authorsIds = AddBookServlet.getAuthorIdsFromStrArr(authorsIdsStr);
        Long categoryId = Long.valueOf(req.getParameter("categoryId"));
        String isbn = req.getParameter("isbn");
        Integer year = Integer.valueOf(req.getParameter("year"));
        Part imagePart = req.getPart("image");

        Book book = Book.builder()
                .id(l)
                .title(title)
                .description(description)
                .year(year)
                .isbn(isbn)
                .authorsIds(authorsIds)
                .categoryId(categoryId)
                .imgFileName(uploadAndGetImageUrl(imagePart, req))
                .build();

        boolean result = BookDao.updateBook(book);

        if (result) {
            resp.sendRedirect("/admin?added=true");
        }


    }
}
