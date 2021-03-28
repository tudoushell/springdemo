package com.elliot.jpa.repository;

import com.elliot.jpa.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: elliot
 * @Date: 2021/2/25
 */
public interface SchoolRepository extends JpaRepository<School, String> {
}
