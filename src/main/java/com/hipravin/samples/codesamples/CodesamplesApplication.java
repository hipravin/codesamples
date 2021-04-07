package com.hipravin.samples.codesamples;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class CodesamplesApplication {

    public static void main(String[] args) {
        SpringApplication.exit(
                SpringApplication.run(CodesamplesApplication.class, args));
    }
//    public static void main(String[] args) {
//        CodesamplesSpringApplication app = new CodesamplesSpringApplication(CodesamplesApplication.class);
//        app.setBannerMode(Banner.Mode.OFF);
//
//        app.run(args);
//    }
}
