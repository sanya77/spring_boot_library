package ru.travin.spring_boot_library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.travin.spring_boot_library.model.BookEntity;
import ru.travin.spring_boot_library.model.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "from UserEntity where id = :id")
    UserEntity findByIdUser(Long id);


}
