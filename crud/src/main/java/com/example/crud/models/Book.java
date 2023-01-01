package com.example.crud.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="table_book")
public class Book {
	
			@Id
			@GeneratedValue(strategy= GenerationType.IDENTITY)
			private long bookId;
			private String bookAuthor;
			private String bookName;
			
			public String getBookAuthor() {
				return bookAuthor;
			}
			public void setBookAuthor(String bookAuthor) {
				this.bookAuthor = bookAuthor;
			}
			 
			
			public String getBookName() {
				return bookName;
			}
			@Override
			public String toString() {
				return "Book [bookId=" + bookId + ", bookAuthor=" + bookAuthor + ", bookName=" + bookName + "]";
			}
			public void setBookName(String bookName) {
				this.bookName = bookName;
			}
			
			
			
}
