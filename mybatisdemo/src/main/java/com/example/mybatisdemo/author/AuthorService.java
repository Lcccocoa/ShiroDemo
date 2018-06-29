package com.example.mybatisdemo.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jpa.authorService")
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll(){
        return this.authorRepository.findAll();
    }

    public Author findAuthor(Long id){
        return this.authorRepository.findById(id).orElse(null);
    }
}
