package cn.edu.zju.filter;

import cn.edu.zju.filter.AuthenticationFilter;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

@Order(1)
public class CommonInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {


        AuthenticationFilter filter = new AuthenticationFilter();
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter(
                "authFilter", filter);
        filterRegistration.addMappingForUrlPatterns(
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/dosingGuideline");


    }


}