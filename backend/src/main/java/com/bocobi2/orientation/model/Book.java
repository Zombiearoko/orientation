package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Book")
public class Book {
	
	@Id
	private String bookId;
	
	private String bookName;
	private String bookAuthor;
	private String bookEdition;
	private double bookPrice;
	private String bookFile;
	
	public Book (){}
	

	public Book(String bookName, String bookAuthor, String bookEdition, double bookPrice, String bookFile) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookEdition = bookEdition;
		this.bookPrice = bookPrice;
		this.bookFile = bookFile;
	}






	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookEdition() {
		return bookEdition;
	}

	public void setBookEdition(String bookEdition) {
		this.bookEdition = bookEdition;
	}

	public String getBookFile() {
		return bookFile;
	}

	public void setBookFile(String bookFile) {
		this.bookFile = bookFile;
	}
	
	   @Override
	    public String toString() {
	        return String.format(
	                "{\"bookId\":%s, \"bookName\":'%s', \"bookAuthor\":'%s',\"bookEdition\":'%s',"
	                + "\"bookFile\":'%s'}",
	                bookId, bookName, bookAuthor,bookEdition,bookFile);
	    }



	public String getBookId() {
		return bookId;
	}



	public void setBookId(String bookId) {
		bookId = bookId;
	}



	public double getBookPrice() {
		return bookPrice;
	}



	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	
	
	
	

}


