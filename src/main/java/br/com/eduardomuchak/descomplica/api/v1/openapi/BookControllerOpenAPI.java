package br.com.eduardomuchak.descomplica.api.v1.openapi;

import br.com.eduardomuchak.descomplica.api.v1.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookControllerOpenAPI {

    ResponseEntity<List<Book>> getAllBooks();

    ResponseEntity<Book> getBookById(@PathVariable Long id);

    ResponseEntity<Book> addBook(@RequestBody Book book);

    ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book);

    ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id);

    ResponseEntity<HttpStatus> deleteAllBooks();
}