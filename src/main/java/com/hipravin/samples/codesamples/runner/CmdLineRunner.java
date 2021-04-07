package com.hipravin.samples.codesamples.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class CmdLineRunner implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(CmdLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Cmd runner");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Cmd runner completed");

    }
}
