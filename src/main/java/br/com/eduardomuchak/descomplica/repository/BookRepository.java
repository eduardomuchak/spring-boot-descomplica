package br.com.eduardomuchak.descomplica.repository;


import br.com.eduardomuchak.descomplica.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}