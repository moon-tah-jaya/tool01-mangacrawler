package com.erith.example.config;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Component
@PropertySource("classpath:global.properties")
@ConfigurationProperties
public class GlobalProperties {

    @Max(5)
    @Min(0)
    @Value("${thread-pool}")
    private int threadPool;

    @NotEmpty
    @Value("${email}")
    private String email;

    //getters and setters

    public int getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(int threadPool) {
        this.threadPool = threadPool;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "GlobalProperties{" +
                "threadPool=" + threadPool +
                ", email='" + email + '\'' +
                '}';
    }
}