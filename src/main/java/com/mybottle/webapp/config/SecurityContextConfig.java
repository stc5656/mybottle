package com.mybottle.webapp.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityContextConfig extends WebSecurityConfigurerAdapter{
	// MVC Framework 
	
	
	@Autowired
	private BasicDataSource dataSource;
	
	// http �κ��� �������� ����
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/member/**").hasAnyRole("ADMIN, MEMBER")
				.antMatchers("/customer/question").authenticated()
				.anyRequest().permitAll()
			.and()
			.formLogin()
				.loginPage("/member/login")
				.loginProcessingUrl("/member/login")
			
			;			
			
			/*.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/academy/**").hasAnyRole("ADMIN, ACADEMY")
			.antMatchers("/teacher/**").hasAnyRole("ADMIN, TEACHER")
			.antMatchers("/student/**").hasAnyRole("ADMIN, STUDENT");*/
	}
	
	// manager �κ��� �������� ��
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select id, pwd password, 1 enable from Member where id = ?")
			.authoritiesByUsernameQuery("select memberId, roleName authority from MemberRole where memberId = ?")
			.passwordEncoder(new BCryptPasswordEncoder());		
		
		
		// 1. ���� ������ ���� ����
		// 2. ��ӵ� �������̽��� ������ ��������� ���� ��ü
				
		// UserBuilder user = User.builder();
		/*auth.inMemoryAuthentication()
			.withUser(user
					.username("seene")
					.password("111")
					.roles("ADMIN"))
			.withUser(user
					.username("jojo")
					.password("222")
					.roles("TEACHER")
					
					
		);*/
		
	}
	 
}
