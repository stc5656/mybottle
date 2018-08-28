package com.mybottle.webapp.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.mybottle.webapp.dao.AlarmDao;
import com.mybottle.webapp.entity.Alarm;



public class MybatisAlarmDao implements AlarmDao {
	
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(Alarm Alarm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Alarm Alarm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Alarm Alarm) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Alarm get(Alarm Alarm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alarm> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alarm> getList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alarm> getList(String field, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alarm> getList(String field, String query, int page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}