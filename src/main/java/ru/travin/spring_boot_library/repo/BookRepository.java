package ru.travin.spring_boot_library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.travin.spring_boot_library.model.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query(value = "from BookEntity where id = :id")
    BookEntity findByIdBook(Long id);

}
