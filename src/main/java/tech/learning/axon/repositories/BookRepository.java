package tech.learning.axon.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.learning.axon.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
