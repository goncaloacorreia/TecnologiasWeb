package TWork;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/registo.html").setViewName("registo.html");
		registry.addViewController("/index.html").setViewName("index.html");
		registry.addViewController("/index2.html").setViewName("index2.html");
		registry.addViewController("/admin.html").setViewName("admin.html");
		registry.addViewController("/advanced_search.html").setViewName("advanced_search.html");
        registry.addViewController("/product.html").setViewName("product.html");
		registry.addViewController("/orders.html").setViewName("orders.html");
	}

}