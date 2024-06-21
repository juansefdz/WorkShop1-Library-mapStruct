package com.example.librosYa.domain.repositories;

import com.example.librosYa.domain.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
