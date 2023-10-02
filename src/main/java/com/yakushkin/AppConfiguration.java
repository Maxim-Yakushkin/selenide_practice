package com.yakushkin;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.springframework.context.annotation.Bean;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@org.springframework.context.annotation.Configuration
public class AppConfiguration {

    @Bean
    public void setup() {
        Configuration.browser = Browsers.EDGE;
        Configuration.pageLoadTimeout = 20000;

        open();
        getWebDriver().manage().window().maximize();
    }
}
