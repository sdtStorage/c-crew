package kr.ac.ewha.cse;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


@EnableAspectJAutoProxy
@EnableCaching
@Controller
@ComponentScan(value = {"kr.ac.ewha.cse"})
@SpringBootApplication
public class CcrewApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcrewApplication.class, args);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext applicationContext)
			throws Exception
	{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		org.springframework.core.io.Resource[] baseResource = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
		sessionFactory.setMapperLocations(baseResource);

		Properties properties = new Properties();
		// user_name"일때 "userName"으로 매핑해주는 옵션 사용 여부
		properties.setProperty("mapUnderscoreToCamelCase", "true");
		// 값이 null인 컬럼 누락 방지
		properties.setProperty("callSettersOnNulls", "true");
		// 디폴트 실행자 설정
		properties.setProperty("defaultExecutorType", "REUSE");
		// 파라미터 값이 null값일 때 JDBC 타입을 명시
		properties.setProperty("jdbcTypeForNull", "NULL");
		sessionFactory.setConfigurationProperties(properties);

		sessionFactory.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
		return sessionFactory.getObject();
	}

	@Bean
	MappingJackson2JsonView jsonViewer()
	{
		return new MappingJackson2JsonView();
	}
}
