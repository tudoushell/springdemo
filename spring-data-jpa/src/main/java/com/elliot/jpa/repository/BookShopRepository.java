package com.elliot.jpa.repository;

import com.elliot.jpa.domain.BookShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookShopRepository extends JpaRepository<BookShop, String> {
}
