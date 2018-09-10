package com.mybottle.webapp.dao;

import java.util.List;

import com.mybottle.webapp.entity.MemberRole;

public interface MemberRoleDao {	

		int insert(MemberRoleDao memberRole);
		int update(MemberRoleDao memberRole);
		int delete(String id);
		
		MemberRoleDao get(String id);
		List<MemberRoleDao> getList();
		List<MemberRole> getList(String memberId);
	}
