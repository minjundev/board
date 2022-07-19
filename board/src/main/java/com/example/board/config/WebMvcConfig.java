package com.example.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.board.interceptor.BoardInterceptor;

@ComponentScan(basePackages = {"com.example.board.controller"}, useDefaultFilters = false, includeFilters = {@Filter(Controller.class), @Filter(ControllerAdvice.class)})
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BoardInterceptor()).addPathPatterns("/**").excludePathPatterns("/sample/**");
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setPrettyPrint(true);
        return converter;
    }


//    @Bean
//    public MarshallingHttpMessageConverter marshallingHttpMessageConverter() {
//        MarshallingHttpMessageConverter converter = new MarshallingHttpMessageConverter();
//        converter.setMarshaller(jaxb2Marshaller());
//        converter.setUnmarshaller(jaxb2Marshaller());
//        return converter;
//    }
//
//    @Bean
//    public Jaxb2Marshaller jaxb2Marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setPackagesToScan(new String[] { "com.example.board.domain" });
//        return marshaller;
//    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true).ignoreAcceptHeader(false).defaultContentType(MediaType.APPLICATION_JSON).mediaType("json", MediaType.APPLICATION_JSON);
    }
}
