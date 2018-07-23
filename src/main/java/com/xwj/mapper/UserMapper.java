package com.xwj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheConfig;

import com.xwj.entity.UserEntity;

@CacheConfig(cacheNames = "baseCache")
public interface UserMapper {
	
	@Select("SELECT id, last_name lastName, email, age FROM xwj_user ")
	List<UserEntity> findAll();
	
	/**
	 * 查询
	 */
//	@Cacheable
	@Select("SELECT id, last_name lastName, email, age FROM xwj_user WHERE id = #{id} and last_name like '%${lastName}%' ")
	UserEntity findById(@Param("id") String id, @Param("lastName") String name);

	/**
	 * 新增
	 */
	@Insert("INSERT INTO xwj_user(id, last_name, age) VALUES(#{id}, #{lastName}, #{age})")
	int addUser(@Param("id") String id, @Param("lastName") String name, @Param("age") Integer age);
	
	/**
	 * 更新
	 */
	@Update("UPDATE xwj_user SET last_name = #{lastName} WHERE id = ${id}")
	int updateUser(@Param("id") String id, @Param("lastName") String name);
	
	/**
	 * 删除
	 */
	@Delete("DELETE FROM xwj_user WHERE id = ${id}")
	int deleteUser(@Param("id") String id);
	
}
