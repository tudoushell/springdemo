package com.elliot.mybatis.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: zhou
 * @date: 2020/5/21
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
  /**
   * 自动分配主键
   */
  @TableId(type = IdType.ASSIGN_UUID)
  private String id;

  private String username;

  private String password;

  @TableField(value = "create_time", fill = FieldFill.INSERT)
  private LocalDateTime createTime;

  @TableField(fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime lastModifyTime;

  @Version
  @TableField(value = "inner_version", fill = FieldFill.INSERT)
  private Integer innerVersion;

  /**
   * 逻辑删除
   */
  @TableLogic
  private Integer isDelete;
}
