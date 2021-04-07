package com.hipravin.samples.codesamples.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 *  from documentation:
 *  Event listeners should not run potentially lengthy tasks as they execute in the same thread by default.
 * Consider using application and command-line runners instead.
 */
@Component
@Profile("!test")
public class StartupListener implements ApplicationListener<ApplicationReadyEvent> {
    private final Logger logger = LoggerFactory.getLogger(StartupListener.class);

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        logger.info("Application ready event");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Some work completed in application ready event");

    }
}
