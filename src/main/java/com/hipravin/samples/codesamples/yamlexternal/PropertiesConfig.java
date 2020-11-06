package com.hipravin.samples.codesamples.yamlexternal;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(SomeApplicationConfigurationProperties.class)
@PropertySource(value = "classpath:someapplication.yml", factory = YamlPropertySourceFactory.class)
public class PropertiesConfig {
}
