package com.erith.example;

import com.erith.example.config.ServerProperties;
import com.erith.example.service.HelloMessageService;
import com.erith.example.service.WeatherService;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
//@ComponentScan("com")
@EnableConfigurationProperties({ServerProperties.class})
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private ServerProperties serverProperties;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private HelloMessageService helloService;

    @Override
    public void run(String... args) throws Exception {
        //weather forecast, default is sunny day!
        logger.info("weatherService.forecast: {}", weatherService.forecast());

        // print server properties
        logger.info("serverProperties: {}", serverProperties);

        // print server hello service
        if (args.length > 0) {
            logger.info("helloService: {}", helloService.getMessage(args[0].toString()));
        } else {
            logger.info("helloService: {}", helloService.getMessage());
        }
        // System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

        // SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            // System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            /*for (String beanName : beanNames) {
                System.out.println(beanName);
            }*/
        };
    }

    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                //-1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });
        return tomcat;
    }

}