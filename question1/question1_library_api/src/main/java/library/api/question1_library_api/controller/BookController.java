package library.api.question1_library_api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import library.api.question1_library_api.model.Book;
import java.util.*;


@RestController
@RequestMapping("/api/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1L, "1984", "George Orwell", "9780451524935", 1949));
        books.add(new Book(2L, "To Kill a Mockingbird", "Harper Lee", "9780060935467", 1960));
        books.add(new Book(3L, "The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925));
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return books;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return  ResponseEntity.ok(book);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public List<Book> searchByTitle(@RequestParam String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        books.add(book);
        return new ResponseEntity<>(book,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
    
    @PostConstruct
    public void init() {
    System.out.println(">>> BookController loaded <<<");
}

}
