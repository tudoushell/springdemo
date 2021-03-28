package com.elliot.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "book")
@Entity
public class Book extends BaseEntity {

  private String bookName;

  @ManyToOne
  @JoinColumn(name = "book_shop_id")
  private BookShop bookShop;

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public void Change(String bookName) {
    this.setBookName(bookName);

  }

  public BookShop getBookShop() {
    return bookShop;
  }

  public void setBookShop(BookShop bookShop) {
    this.bookShop = bookShop;
  }
}
