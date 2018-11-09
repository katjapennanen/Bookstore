package fi.haagahelia.sp.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.sp.bookstore.domain.Book;
import fi.haagahelia.sp.bookstore.domain.Category;
import fi.haagahelia.sp.bookstore.domain.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository crepo;
	
	@Test
	public void findByNameShouldReturnBook() {
		List<Category> categories = crepo.findByName("Horror");
	}
	
	@Test
	public void createNewCategory() {
		Category cat = new Category("Comic");
		crepo.save(cat);
		assertThat(cat.getCategoryId()).isNotNull();
	}
}
