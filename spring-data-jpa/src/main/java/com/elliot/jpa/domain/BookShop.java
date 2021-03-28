package com.elliot.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table(name = "bookshop")
@Entity
public class BookShop extends BaseEntity{

  private String name;

  private String address;

  @OneToMany(mappedBy = "bookShop")
  private List<Book> bookList = new ArrayList<>();
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<Book> getBookList() {
    return bookList;
  }

  public void setBookList(List<Book> bookList) {
    this.bookList = bookList;
  }

  public void change(String name, String address) {
    this.setAddress(address);
    this.setName(name);
  }


  public void addBook(String bookName) {
     Book book = new Book();
     book.setBookName(bookName);
     bookList.add(book);
  }

  public void updateBook(Book book) {
    for (Book oldBook : bookList) {
      if (oldBook.getId().equals(book.getId())) {
        oldBook.Change(book.getBookName());
        break;
      }
    }
  }

  public void removeBook(String bookId) {
    for (Book book : bookList) {
      if (book.getId().equals(bookId)) {
        bookList.remove(book);
        break;
      }
    }
  }
}
