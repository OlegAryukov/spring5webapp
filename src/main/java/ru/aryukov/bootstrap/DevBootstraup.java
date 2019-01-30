package ru.aryukov.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.aryukov.model.Author;
import ru.aryukov.model.Books;
import ru.aryukov.model.Publisher;
import ru.aryukov.repository.AuthorRepository;
import ru.aryukov.repository.BookRepository;
import ru.aryukov.repository.PublisherRepository;

/**
 * Created by oaryukov on 30.01.2019.
 */
@Component
public class DevBootstraup implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstraup(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("Some awsome publisher");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Books ericBoock = new Books("Domain Driven Design", publisher,"12345");
        eric.getBooks().add(ericBoock);
        ericBoock.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ericBoock);

        Author rod = new Author("Rod", "Johnson");
        Books noEJB = new Books("JEE Development without EJB",publisher, "22444");
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
