package com.stackroute.oops;

public class BookService {

  /*
        This method should create an author object using the values of author properties passed as parameters
        and return the author object
    */
  public Author createAuthor(String name, String country) {
    return new Author(name, country);
  }

  /*
        This method should create a book object using the values of book and author properties passed as parameters
        and return the book object
    */
  public Book createBook(
    long isbn,
    String bookTitle,
    String bookEdition,
    String authorName,
    String authorCountry
  ) {
    return new Book(
      isbn,
      bookTitle,
      bookEdition,
      new BookService().createAuthor(authorName, authorCountry)
    );
  }
}
