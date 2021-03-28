package com.elliot.jpa.service;

import com.elliot.jpa.domain.Book;
import com.elliot.jpa.domain.BookShop;
import com.elliot.jpa.repository.BookRepository;
import com.elliot.jpa.repository.BookShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookShopService {

  @Autowired
  private BookShopRepository bookShopRep;

  @Autowired
  private BookRepository bookRepository;


  @Transactional(readOnly = true)
  public void test() {
    Optional<Book> byId = bookRepository.findById("12");
    Book book = byId.get();
    System.out.println(book.getBookShop().getBookList().get(0));
  }

  /**
   * cacheManager 管理多个cache组件
   * @Cacheable 的属性
   *  cacheName/value: 指定缓存组件的名字
   *  key: 缓存数据使用的key：可以用它来指定。默认是使用方法参数的值
   *      返回的是缓存中的数据
   *      编写SpEL: #id;参数id的值 #a0 #root.args[0]
   *  keyGenerator: key的生成器，可以自己指定key的生成器的组件id
   *      key/keyGenerator 二选一使用
   *  CacheManager: 指定缓存管理器 或者 cacheResolver指定获取解析器
   *  condition: 指定符合条件的情况下才缓存
   *  unless: 否定缓存; 当unless为true，方法的返回值就不会缓存;可以获取到结果进行判断
   *  sync： 是否使用异步模式
   * @return
   */
  @Cacheable(cacheNames = "bookshop")
  public List<BookShop> list() {
    return bookShopRep.findAll();
  }

  @Transactional(rollbackFor = Exception.class)
  public void update(BookShop newBookShop) {
    Optional<BookShop> optionalBookShop =
            bookShopRep.findById(newBookShop.getId());
    BookShop oldBookShop = optionalBookShop.get();
    oldBookShop.getBookList().clear();
    oldBookShop.change(newBookShop.getName(), newBookShop.getAddress());

    oldBookShop.getBookList().addAll(newBookShop.getBookList());
    bookShopRep.save(oldBookShop);
  }
}
