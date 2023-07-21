package tech.learning.axon.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.learning.axon.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
