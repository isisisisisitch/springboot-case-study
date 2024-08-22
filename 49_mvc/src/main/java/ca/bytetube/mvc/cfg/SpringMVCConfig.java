package ca.bytetube.mvc.cfg;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
//@EnableWebMvc
public class SpringMVCConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/abc/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/abc/**").addResourceLocations("file:///Users/dalluo/Desktop/upload/");

    }



//    @Override
//   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        StringHttpMessageConverter converter = new StringHttpMessageConverter();
//        converter.setDefaultCharset(StandardCharsets.UTF_8);
//        converters.add(converter);
//    }

}
