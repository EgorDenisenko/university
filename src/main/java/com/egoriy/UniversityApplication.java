package com.egoriy;

import org.apache.catalina.Container;
import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.lightadmin.api.config.LightAdmin;
import org.lightadmin.core.config.LightAdminWebApplicationInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.context.embedded.ServletContextInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
public class UniversityApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                LightAdmin.configure(servletContext)
                        .basePackage("com.egoriy.administration")
                        .baseUrl("/admin")
                        .security(true)
                        .backToSiteUrl("http://localhost:8080/");

                new LightAdminWebApplicationInitializer().onStartup(servletContext);
            }
        };
    }

    @Bean
    public EmbeddedServletContainerCustomizer servletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {

            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                if (container instanceof TomcatEmbeddedServletContainerFactory) {
                    customizeTomcat((TomcatEmbeddedServletContainerFactory) container);
                }
            }

            private void customizeTomcat(TomcatEmbeddedServletContainerFactory tomcatFactory) {
                tomcatFactory.addContextCustomizers(new TomcatContextCustomizer() {

                    @Override
                    public void customize(Context context) {
                        Container jsp = context.findChild("jsp");
                        if (jsp instanceof Wrapper) {
                            ((Wrapper) jsp).addInitParameter("development", "false");
                        }

                    }

                });
            }

        };
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UniversityApplication.class);
    }
}
