package uz.pdp.librarymanagementsystem.i_r_book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.librarymanagementsystem.books.Book;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class I_R_book {
    private Long id;
    private Date date;
    private Boolean is_issued;

    private Long student_id;

    private Set<Book> book_ids;

    private Set<Long> books;
}
