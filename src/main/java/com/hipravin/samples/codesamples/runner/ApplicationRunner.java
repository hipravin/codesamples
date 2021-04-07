package com.hipravin.samples.codesamples.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {
    private final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);


    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("App runner");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("App runner completed");

    }
}
