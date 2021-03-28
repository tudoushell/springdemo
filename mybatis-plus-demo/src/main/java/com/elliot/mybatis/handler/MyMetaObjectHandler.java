package com.elliot.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author: zhou
 * @date: 2020/5/21
 * 自动填充功能
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
  @Override
  public void insertFill(MetaObject metaObject) {
    this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
    this.strictInsertFill(metaObject, "lastModifyTime", LocalDateTime.class, LocalDateTime.now());
    this.strictInsertFill(metaObject, "innerVersion", Integer.class, 1);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    this.strictInsertFill(metaObject, "lastModifyTime", LocalDateTime.class, LocalDateTime.now());
  }
}
