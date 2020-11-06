package com.hipravin.samples.codesamples.yamlexternal;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "someapplication")
public class SomeApplicationConfigurationProperties {
    private List<String> servers = new ArrayList<String>();

    private String parameter1;

    private SubProperties subProperties;

    public SubProperties getSubProperties() {
        return subProperties;
    }

    public void setSubProperties(SubProperties subProperties) {
        this.subProperties = subProperties;
    }

    public static class SubProperties {
        private Long subproperty1;
        private String subproperty2;

        public Long getSubproperty1() {
            return subproperty1;
        }

        public void setSubproperty1(Long subproperty1) {
            this.subproperty1 = subproperty1;
        }

        public String getSubproperty2() {
            return subproperty2;
        }

        public void setSubproperty2(String subproperty2) {
            this.subproperty2 = subproperty2;
        }
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }
}
