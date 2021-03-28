import com.elliot.jpa.Application;
import com.elliot.jpa.domain.Book;
import com.elliot.jpa.domain.BookShop;
import com.elliot.jpa.domain.School;
import com.elliot.jpa.domain.Student;
import com.elliot.jpa.repository.BookRepository;
import com.elliot.jpa.repository.BookShopRepository;
import com.elliot.jpa.repository.SchoolRepository;
import com.elliot.jpa.repository.StudentRepository;
import com.elliot.jpa.service.BookShopService;
import com.elliot.jpa.service.SchoolService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringTest {

  @Autowired
  private BookShopRepository bookShopRepository;

  @Autowired
  private BookShopService bookShopService;

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private SchoolRepository schoolRepository;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private SchoolService schoolService;

  @Test
  public void test3() {
   schoolService.save();
  }


  @Test
  public void test2(){
    BookShop newBookShop = new BookShop();
    newBookShop.setId("4028818672c2ac790172c2ac81a30000");
    newBookShop.setAddress("newAddress");
    newBookShop.setName("new");

    Optional<Book> byId = bookRepository.findById("4028818672c2ac790172c2ac81bd0001");
    Book book = byId.get();
    book.setBookName("hero2323");
    Book book2 = new Book();
    book2.setBookName("book23");
    List<Book> newBookList = new ArrayList<>();
    newBookList.add(book);
    newBookList.add(book2);
    newBookShop.setBookList(newBookList);
    bookShopService.update(newBookShop);
  }

  @Test
  public void test() {
    List<BookShop> list = bookShopService.list();
    System.out.println(list);
  }
}
