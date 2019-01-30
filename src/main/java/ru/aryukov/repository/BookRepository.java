package ru.aryukov.repository;

import org.springframework.data.repository.CrudRepository;
import ru.aryukov.model.Books;

/**
 * Created by oaryukov on 30.01.2019.
 */
public interface BookRepository extends CrudRepository<Books, Long> {
}
