package br.com.eduardomuchak.descomplica.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

}
