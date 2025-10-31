package com.bookstore.controller;

import com.bookstore.model.Author;
import com.bookstore.repository.AuthorRepo;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/authors")
public class AuthorContr {

    private final AuthorRepo repo;

    public AuthorContr(AuthorRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return repo.findAll();
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return repo.save(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        author.setId(id);
        return repo.save(author);
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
