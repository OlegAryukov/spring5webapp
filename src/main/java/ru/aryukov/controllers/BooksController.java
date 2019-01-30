package ru.aryukov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.aryukov.repository.BookRepository;

/**
 * Created by oaryukov on 30.01.2019.
 */
@Controller
public class BooksController {

    private BookRepository bookRepository;

    public BooksController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }
}
