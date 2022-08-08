package uz.pdp.librarymanagementsystem.books;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.librarymanagementsystem.authors.Author;
import uz.pdp.librarymanagementsystem.category.Category;
import uz.pdp.librarymanagementsystem.user.User;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
    private Long id;
    private String title;
    private String description;
    private Set<Author> authors; // for get/edit

    private Set<Long> authorsIds; // for insert/update
    private Category category; // for get/edit

    private Long categoryId; // for insert/update
    private String isbn;
    private Integer year;
    private String imgFileName;

    private Set<Long> usersIds;
    private Set<User> users;


    public Book(Long id, String title, String description, Set<Author> authors, Category category, String isbn,
                Integer year, String imgFileName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authors = authors;
        this.category = category;
        this.isbn = isbn;
        this.year = year;
        this.imgFileName = imgFileName;
    }
}
