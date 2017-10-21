package ua.com.owu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.File;

@Configuration
@EnableWebMvc
@ComponentScan("ua.com.owu")
public class WebConfig extends WebMvcConfigurerAdapter{

//    @Bean
//    public JavaMailSenderImpl javaMailSender(){
//        JavaMailSenderImpl javaMailSender=new JavaMailSenderImpl();
//        javaMailSender.setHost("smtp.gmail.com");
//        javaMailSender.setPort(587);
//        javaMailSender.setUsername("Oleggema@gmail.com");
//        javaMailSender.setPassword("526098og");
//        Properties properties=javaMailSender.getJavaMailProperties();
//        properties.put("mail.transport.protocol","smtp");
//        properties.put("mail.smtp.auth","true");
//        properties.put("mail.smtp.starttls.enable","true");
//        properties.put("mail.debug","true");
//        return javaMailSender;
//    }

    @Bean
    public MultipartResolver multipartResolver(){

        return new StandardServletMultipartResolver();
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/javascript/**").addResourceLocations("/WEB-INF/javascript/");
        registry.addResourceHandler("/image/**").addResourceLocations("/static/images/");
        registry.addResourceHandler("/avatar/**").addResourceLocations("file:"+System.getProperty("user.home")+ File.separator+"images\\");
        registry.addResourceHandler("/productPhoto/**").addResourceLocations("file:"+System.getProperty("user.home")+ File.separator+"productImages\\");
    }
}
