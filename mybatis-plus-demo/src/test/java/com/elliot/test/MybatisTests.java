package com.elliot.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elliot.mybatis.MybatisPlusDemo;
import com.elliot.mybatis.dao.UserDao;
import com.elliot.mybatis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: zhou
 * @date: 2020/5/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisPlusDemo.class)
public class MybatisTests {
  @Autowired
  private UserDao userDao;

  @Test
  public void selectQuery() {
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    wrapper.eq("username", "hhhhh");
    wrapper.orderByDesc("lastModifyTime");
    List<User> users = userDao.selectList(wrapper);
    System.out.println(users);
  }

  @Test
  public void pageSearch() {
    Page<User> page = new Page<>(1, 2);
    Page<User> result = userDao.selectPage(page, Wrappers.<User>lambdaQuery().orderByDesc(User::getLastModifyTime));
    System.out.println(result.getCurrent());
  }

  @Test
  public void update() {
    User user = userDao.selectById("c17b35f8c696be284132e72b93e6cd8d");
    user.setPassword("123457");
    int update = userDao.update(user, null);
    System.out.println(update);
  }

  @Test
  public void testInsert() {
    User user = new User();
    user.setUsername("logic");
    user.setPassword("bbbb");
    userDao.insert(user);
  }
}
