package com.elliot.jpa.controller;

import com.elliot.jpa.domain.BookShop;
import com.elliot.jpa.service.BookShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BookShopController {

  @Resource
  private BookShopService bookShopService;

  @GetMapping("/bookshop")
  public List<BookShop> list() {
    return bookShopService.list();
  }
}
