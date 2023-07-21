package tech.learning.axon.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.learning.axon.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
