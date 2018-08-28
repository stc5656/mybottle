package com.mybottle.webapp.dao;

import java.util.List;

import com.mybottle.webapp.entity.Alarm;

public interface AlarmDao {
	
	int insert(Alarm Alarm);
	int update(Alarm Alarm);
	int delete(Alarm Alarm);
	
	Alarm get(Alarm Alarm);
	List<Alarm> getList();
	List<Alarm> getList(int page);
	List<Alarm> getList(String field, String query);
	List<Alarm> getList(String field, String query, int page);
	
}
