package com.bookstore.dao;


import com.bookstore.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
	public List<User> getAll();/*都用的resultMap一个返回list，一个返回user*/
	public User getUserById(@Param("id") Integer id);/* @Param("id")是什么意思*/
	public void insertUser(User user);
}
