package ru.aryukov.repository;

import org.springframework.data.repository.CrudRepository;
import ru.aryukov.model.Publisher;

/**
 * Created by oaryukov on 30.01.2019.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long>{
}
