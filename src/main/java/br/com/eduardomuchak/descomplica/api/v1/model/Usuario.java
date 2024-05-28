package br.com.eduardomuchak.descomplica.api.v1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_nome")
    private String nome;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;
}