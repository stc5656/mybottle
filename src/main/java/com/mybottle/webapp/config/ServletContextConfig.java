package com.mybottle.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration

@ComponentScan(basePackages="com.mybottle.webapp.controller")

@EnableWebMvc
public class ServletContextConfig implements WebMvcConfigurer{

	/*���� Ŭ������ ��üȭ�ؼ� ������ �̸����� loC�� ����ּ���*/ 
	
	@Bean // �̰� ���� ��ü�� ������ ���ϴ� ������̼�!!
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(2);
		
		return resolver;	
		
	}	
	
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		
		/*tilesConfigurer.setDefinitions(new String[] {"a", "b"});*/
		tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
				
		return tilesConfigurer;		
		
	}	
	
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		
		resolver.setViewClass(TilesView.class);
		resolver.setOrder(1);
		
		return resolver;	
		
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// <mvc:resources location="/resources/" mapping="/resources/**"/>
		registry
			.addResourceHandler("/resources/**")
			.addResourceLocations("/resources/");
		
		
		
	}
	
}




