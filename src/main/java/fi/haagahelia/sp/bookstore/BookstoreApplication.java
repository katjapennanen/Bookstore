package fi.haagahelia.sp.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import fi.haagahelia.sp.bookstore.domain.Book;
import fi.haagahelia.sp.bookstore.domain.BookRepository;
import fi.haagahelia.sp.bookstore.domain.Category;
import fi.haagahelia.sp.bookstore.domain.CategoryRepository;
import fi.haagahelia.sp.bookstore.domain.User;
import fi.haagahelia.sp.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books and create categories");

			crepository.save(new Category("Horror"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Science Fiction"));
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Graphic Novel"));

			brepository.save(new Book("It", "Stephen King", "1234567890123", 1986, 20.99, crepository.findByName("Horror").get(0)));
			brepository.save(new Book("Return of the King", "J.R.R. Tolkien", "1234567890123", 1955, 20.12, crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "1234567890123", 1980, 20.99, crepository.findByName("Science Fiction").get(0)));
			brepository.save(new Book("And the Ass Saw the Angel", "Nick Cave", "1234567890123", 1989, 20.99, crepository.findByName("Fiction").get(0)));
			brepository.save(new Book("Maus", "Art Spiegelman", "1234567890123", 1991, 20.99, crepository.findByName("Graphic Novel").get(0)));
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$04$19ycEAQTqV66Cg4bZt9oR.xTEzfEaEXLrr/dSsOBVIjNr/ep3wtEm", "USER");
			User user2 = new User("admin", "$2a$04$txKbHel.N18yPJDEufmO..KFpUHaCa9AY7Am.fQdTou8uE8qZgOU6", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
