package com.example.mybatisdemo.author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAll();
    Optional<Author> findById(Long id);
}
