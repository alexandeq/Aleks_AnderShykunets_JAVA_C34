package org.example.web.config;

import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ServletConfiguration implements WebApplicationInitializer {

    @Override
    public void onStartup(jakarta.servlet.ServletContext servletContext) throws ServletException {

        var context = new AnnotationConfigWebApplicationContext();
        context.scan("org.example.web");

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        servletContext.addServlet("dispatcher", dispatcherServlet)
                .addMapping("/");
    }
}

