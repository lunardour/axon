package tech.learning.axon.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.learning.axon.domain.Author;
import tech.learning.axon.domain.Book;
import tech.learning.axon.domain.Publisher;
import tech.learning.axon.repositories.AuthorRepository;
import tech.learning.axon.repositories.BookRepository;
import tech.learning.axon.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher penguin = new Publisher("Penguin Books", "One Embassy Gardens", "London", "England", "SW11 7BW");

        publisherRepository.save(penguin);

        Author dante = new Author("Dante", "Alighieri");
        Book comedy = new Book("The Divine Comedy", "463180");
        dante.getBooks().add(comedy);
        comedy.getAuthors().add(dante);
        comedy.setPublisher(penguin);
        penguin.getBooks().add(comedy);

        authorRepository.save(dante);
        bookRepository.save(comedy);
        publisherRepository.save(penguin);

        Author herman = new Author("Herman", "Melville");
        Book moby = new Book("Moby Dick", "255650");
        herman.getBooks().add(moby);
        moby.getAuthors().add(herman);
        moby.setPublisher(penguin);
        penguin.getBooks().add(moby);

        authorRepository.save(herman);
        bookRepository.save(moby);
        publisherRepository.save(penguin);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("First publisher's number of books: " + penguin.getBooks().size());
    }
}
