package ru.aryukov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.aryukov.repository.AuthorRepository;

/**
 * Created by oaryukov on 30.01.2019.
 */
@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }
}
