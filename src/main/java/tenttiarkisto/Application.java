package tenttiarkisto;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("4MB");
        factory.setMaxRequestSize("4MB");
        return factory.createMultipartConfig();
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return new ServletContextInitializer() {

            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
                characterEncodingFilter.setEncoding("UTF-8");
                characterEncodingFilter.setForceEncoding(false);

                // TODO Blog
                servletContext.addFilter("characterEncodingFilter", characterEncodingFilter).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
            }

        };
    }
}
