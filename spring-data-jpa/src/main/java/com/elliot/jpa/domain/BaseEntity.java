package com.elliot.jpa.domain;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
  @Id
  @GeneratedValue(generator = "book")
  @GenericGenerator(name = "book", strategy = "uuid")
  private String id;

  @CreatedDate
  @Column(columnDefinition = "datetime")
  private Date createTime;

  @LastModifiedDate
  @Column(columnDefinition = "datetime")
  private Date lastModifyTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getLastModifyTime() {
    return lastModifyTime;
  }

  public void setLastModifyTime(Date lastModifyTime) {
    this.lastModifyTime = lastModifyTime;
  }
}
