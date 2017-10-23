package com.erith.example.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"sunny", "default"})
public class SunnyDayService implements WeatherService {

    public SunnyDayService() {
        System.out.println("::: SunnyDayService");
    }

    @Override
    public String forecast() {
        return "Today is sunny day!";
    }

}