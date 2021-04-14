package com.elliot.security.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: elliot
 * @Date: 2021/4/14
 */
@Data
@TableName(value = "rbac_user")
public class UserEntity {
	private String id;
	private String username;
	private String password;
	private String nickname;
	private String headImgUrl;
	private String phone;
	private String email;
	private Integer sex;
	private String status;
	private LocalDateTime createTime;
	private LocalDateTime lastModifyTime;
}
