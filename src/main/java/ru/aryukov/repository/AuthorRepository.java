package ru.aryukov.repository;

import org.springframework.data.repository.CrudRepository;
import ru.aryukov.model.Author;

/**
 * Created by oaryukov on 30.01.2019.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
