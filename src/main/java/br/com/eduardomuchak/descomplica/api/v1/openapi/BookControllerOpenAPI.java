package br.com.eduardomuchak.descomplica.api.v1.openapi;

import br.com.eduardomuchak.descomplica.api.v1.model.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Books")
public interface BookControllerOpenAPI {

    @Operation(summary = "Retorna todos os livros")
    ResponseEntity<List<Book>> getAllBooks();

    @Operation(summary = "Retorna um livro pelo ID")
    ResponseEntity<Book> getBookById(@PathVariable Long id);

    @Operation(summary = "Adiciona um livro")
    ResponseEntity<Book> addBook(@RequestBody Book book);

    @Operation(summary = "Atualiza um livro pelo ID")
    ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book);

    @Operation(summary = "Deleta um livro pelo ID")
    ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id);

    @Operation(summary = "Deleta todos os livros")
    ResponseEntity<HttpStatus> deleteAllBooks();
}