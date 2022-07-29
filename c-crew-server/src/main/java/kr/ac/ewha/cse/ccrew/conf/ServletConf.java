package kr.ac.ewha.cse.ccrew.conf;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import kr.ac.ewha.cse.CcrewApplication;

public class ServletConf extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CcrewApplication.class);
	}
}
