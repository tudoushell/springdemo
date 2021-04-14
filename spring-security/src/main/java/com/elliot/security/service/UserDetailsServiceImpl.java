package com.elliot.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.elliot.security.domain.UserEntity;
import com.elliot.security.mapper.UserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: elliot
 * @Date: 2021/4/13
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Resource
	private UserMapper userMapper;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", username);
		UserEntity userEntity = userMapper.selectOne(queryWrapper);
		if (userEntity == null) {
			throw new UsernameNotFoundException("username not found");
		}
		//权限
		List<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("admin"));
		return new User(username, new BCryptPasswordEncoder().encode(userEntity.getPassword()), authorityList);
	}
}
