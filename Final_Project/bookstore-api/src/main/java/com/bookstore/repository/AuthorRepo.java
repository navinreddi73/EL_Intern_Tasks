package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.model.Author;

public interface AuthorRepo extends JpaRepository<Author, Long> {}
