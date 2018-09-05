package com.mybottle.webapp.dao;

import java.util.List;

import javax.management.relation.Role;

public interface RoleDao {

	int insert(Role role);
	int update(Role role);
	int delete(String id);
	
	Role get(String id);
	List<Role> getList();
}
