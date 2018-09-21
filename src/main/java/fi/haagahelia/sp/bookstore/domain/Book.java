package fi.haagahelia.sp.bookstore.domain;

import java.util.function.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
	public class Book {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)

		private long id;
		private String title, author, isbn;
		private int year;
		private double price;
		
		public Book() {
		}
		
		public Book(String title, String author, int year, String isbn, double price) {
			super();
			this.title = title;
			this.author = author;
			this.year = year;
			this.isbn = isbn;
			this.price = price;
		}
		
		//* GETTERS
		public String getTitle() {
			return title;
		}
		
		public String getAuthor() {
			return author;
		}
		
		public int getYear() {
			return year;
		}
		
		public String getIsbn() {
			return isbn;
		}
		
		public double getPrice() {
			return price;
		}
		
		//* SETTERS
		public void setTitle(String title) {
			this.title = title;
		}
		
		public void setAuthor(String author) {
			this.author = author;
		}
		
		public void setYear(int year) {
			this.year = year;
		}
		
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		
		public void setPrice(double price) {
			this.price = price;
		}
	}
