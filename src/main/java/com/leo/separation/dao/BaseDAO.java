package com.leo.separation.dao;

import java.util.List;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlRenameTableStatement.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
//@Mapper
public interface BaseDAO<T>{
    public void insert(T t);
	
	public void update(T t);
	
	//删除
	public void delete(Integer id);

	public T findId(Integer id);
	
	public T find(String name);
	//查询总条数
	public Integer queryCount();
	//查询所有
	public List<T> queryAll();
	//mybatis的分页插件
	List<Item> pagePlug(@Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);
	
}