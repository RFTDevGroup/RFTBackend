package com.rftdevgroup.transporthub.configuration.yaml;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class CustomYamlConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yamlPropertiesFactory = new YamlPropertiesFactoryBean();
        ConfigurationFileResourceResolver configurationFileResourceResolver = new ConfigurationFileResourceResolver();

        yamlPropertiesFactory.setResources(configurationFileResourceResolver.getResourceArray());
        propertySourcesPlaceholderConfigurer.setProperties(yamlPropertiesFactory.getObject());

        return propertySourcesPlaceholderConfigurer;
    }
}
