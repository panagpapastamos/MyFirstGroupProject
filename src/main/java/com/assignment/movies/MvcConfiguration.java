package com.assignment.movies;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/movies").setViewName("movies");
        registry.addViewController("/users").setViewName("users");
        registry.addViewController("/payment").setViewName("payment");
        registry.addViewController("/admin").setViewName("admin");

    }

}
