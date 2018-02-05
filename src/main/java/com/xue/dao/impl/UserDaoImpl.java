package com.xue.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.StringUtils;
import com.xue.bean.RoncooUser;
import com.xue.dao.UserDao;
import com.xue.util.base.JdbcDaoImpl;
import com.xue.util.base.Page;
import com.xue.util.base.Sql;

@Repository
public class UserDaoImpl extends JdbcDaoImpl implements UserDao {

	@Override
	public int insert(RoncooUser roncooUser) {
		String sql = "insert into roncoo_user (name, create_time) values (?, ?)";
		return jdbcTemplate.update(sql, roncooUser.getName(),
				roncooUser.getCreateTime());
	}
	@Override
	public int deleteById(int id) {
		String sql = "delete from roncoo_user where id=?";
		return jdbcTemplate.update(sql, id);
	}
	@Override
	public int updateById(RoncooUser roncooUser) {
		String sql = "update roncoo_user set name=?, create_time=? where id=?";
		return jdbcTemplate.update(sql, roncooUser.getName(),
				roncooUser.getCreateTime(), roncooUser.getId());
	}
	
	@Override
	public RoncooUser selectById(int id) {
		String sql = "select * from roncoo_user where id=?";
		/*return jdbcTemplate.queryForObject(sql, new RowMapper<RoncooUser>() {
			@Override
			public RoncooUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				RoncooUser roncooUser = new RoncooUser();
				roncooUser.setId(rs.getInt("id"));
				roncooUser.setName(rs.getString("name"));
				roncooUser.setCreateTime(rs.getDate("create_time"));
				return roncooUser;
			}
		}, id);*/
		
		return queryForObject(sql, RoncooUser.class, id);
	}
	
	@Override
	public Page<RoncooUser> queryForPage(int pageCurrent, int pageSize, String name) {
		
		// 若要like查询，如下
		StringBuffer sql = new StringBuffer("select * from roncoo_user where 1=1");
		if(!StringUtils.isNullOrEmpty(name)){
			// Sql.checkSql 的作用是防止sql注入
			sql.append(" and name like '%").append(Sql.checkSql(name)).append("%' ");
		}
		return queryForPage(sql.toString(), pageCurrent, pageSize, RoncooUser.class);
	}
}
