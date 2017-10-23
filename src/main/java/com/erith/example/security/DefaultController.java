package com.erith.example.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.erith.example.config.AppProperties;
import com.erith.example.config.GlobalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @Autowired
    private AppProperties app;

    @Autowired
    private GlobalProperties global;

    @GetMapping("/")
    public String home1() {
        logger.info("Welcome {}, {}", app, global);
        // System.out.println("Welcome " + app + ", " + global);
        return "/home";
    }

    @GetMapping("/ajaxSearch")
    public String ajaxSearch() {
        return "/ajax";
    }

    @GetMapping("/ajaxUpload")
    public String ajaxUpload() {
        return "/upload";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}