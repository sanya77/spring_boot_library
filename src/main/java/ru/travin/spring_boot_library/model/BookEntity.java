package ru.travin.spring_boot_library.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameBook;
    private String author;
    private int releaseBook;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
}
