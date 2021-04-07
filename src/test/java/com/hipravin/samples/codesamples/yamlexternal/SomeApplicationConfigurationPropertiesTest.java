package com.hipravin.samples.codesamples.yamlexternal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles({"test", "dev"})
class SomeApplicationConfigurationPropertiesTest {

    @Autowired
    SomeApplicationConfigurationProperties someApplicationConfigurationProperties;

    @Test
    void testConfigLoads() {
        assertEquals(2, someApplicationConfigurationProperties.getServers().size());
        assertEquals("server1", someApplicationConfigurationProperties.getServers().get(0));
        assertEquals("server2", someApplicationConfigurationProperties.getServers().get(1));

        assertEquals("parametervalue1", someApplicationConfigurationProperties.getParameter1());
        assertEquals(10L, someApplicationConfigurationProperties.getSubProperties().getSubproperty1());
        assertEquals("subpropertyvalue2", someApplicationConfigurationProperties.getSubProperties().getSubproperty2());
    }
}