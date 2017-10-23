package nl.MensErgerJeNiet.mensergerjeniet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/").setViewName("home");
        
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("user");
        
        registry.addViewController("/mejn/**").setViewName("mejn");
        registry.addViewController("/highscores").setViewName("highscores");

        registry.addViewController("/admin").setViewName("adminpage");
        registry.addViewController("/403").setViewName("403");
        
        registry.addViewController("/hello").setViewName("hello");
    }    
    
    @Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}  
}