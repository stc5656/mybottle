package com.mybottle.webapp.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybottle.webapp.dao.MemberRoleDao;
import com.mybottle.webapp.entity.MemberRole;


@Service
public class MybatisHomeService {
	// ioc占쏙옙 占쏙옙占쏙옙 占식울옙 占쏙옙占쏙옙占쌕곤옙 占쏙옙占승곤옙
		@Autowired
		private MemberRoleDao memberRoleDao;	
		
		public String getDefaultRoleName(String memberId) {
			
			List<MemberRole> list = memberRoleDao.getList(memberId);
				
			String roleName = "ROLE_STUDENT";
			for(MemberRole role : list)
				if(role.getDefaultRole())
					roleName = role.getRoleName();		
			
			
			return roleName;		
		}	
	}