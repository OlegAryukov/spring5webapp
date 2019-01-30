package ru.aryukov.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by oaryukov on 11.01.2019.
 */

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;

    @OneToOne
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_books", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Books() {
    }

    public Books(String title, Publisher publisher, String isbn) {
        this.title = title;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public Books(String title, Publisher publisher, String isbn, Set<Author> authors) {
        this.title = title;
        this.publisher = publisher;
        this.isbn = isbn;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        return id != null ? id.equals(books.id) : books.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }
}
