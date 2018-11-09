package fi.haagahelia.sp.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.sp.bookstore.domain.Book;
import fi.haagahelia.sp.bookstore.domain.BookRepository;
import fi.haagahelia.sp.bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository brepo;
	
	@Test
	public void findByNameShouldReturnBook() {
		List<Book> books = brepo.findByTitle("It");
		 assertThat(books).hasSize(1);
	     assertThat(books.get(0).getAuthor()).isEqualTo("Stephen King");
	}
	
	@Test
    public void createNewBook() {
    	Book book = new Book("Title", "Author", "1234567890123", 1986, 20.99, new Category("Test"));
    	brepo.save(book);
    	assertThat(book.getId()).isNotNull();
    }
	
	//@Test
	//public void deleteBook() {
		//Book book2 = new Book("Title", "Author", "1234567890123", 1986, 20.99, new Category("Test2"));
		//brepo.deleteById(book2.getId());
		//assertThat(book2.getId()).isNull();
	//}
}
