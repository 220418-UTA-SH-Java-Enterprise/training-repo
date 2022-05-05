package com.revature.example;

//this class will serve as our Comparable example

public class Book implements Comparable<Book>{

	private double rating;
	private String title;
	private String author;
	private int yearPublished;
	private double price;
	
	@Override
	public int compareTo(Book o) {
		// this method is used to sort books by year
		return this.yearPublished - o.yearPublished;
	}

	public Book(double rating, String title, String author, int yearPublished, double price) {
		super();
		this.rating = rating;
		this.title = title;
		this.author = author;
		this.yearPublished = yearPublished;
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [rating=" + rating + ", title=" + title + ", author=" + author + ", yearPublished=" + yearPublished
				+ ", price=" + price + "]";
	}
}
