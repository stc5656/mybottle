package com.mybottle.webapp.dao.mybatis.mapper;

import java.util.List;

import com.mybottle.webapp.entity.Member;


public interface MemberDao {
	
	int insert(Member member);
	int update(Member member);
	int delete(String id);
	
	Member get(String id);
	List<Member> getList();
	List<Member> getList(int page);
	List<Member> getList(String field, String query);
	List<Member> getList(String field, String query, int page);
	
}
