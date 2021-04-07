package com.hipravin.samples.codesamples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

public class CodesamplesSpringApplication extends SpringApplication {
    private static final Logger log = LoggerFactory.getLogger(CodesamplesSpringApplication.class);

    public CodesamplesSpringApplication(Class<?>... primarySources) {
        super(primarySources);
    }

    @Override
    protected void logStartupInfo(boolean isRoot) {
        log.info("Additional startup logging");

        super.logStartupInfo(isRoot);
    }
}
