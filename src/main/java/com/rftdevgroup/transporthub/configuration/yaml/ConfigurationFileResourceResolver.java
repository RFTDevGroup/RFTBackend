package com.rftdevgroup.transporthub.configuration.yaml;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConfigurationFileResourceResolver {
    private final String[] CONFIGS = {"main"};
    private final String PROFILE_CONFIG_PREFIX = "config-";
    private final String PROFILE_CONFIG_SUFFIX = ".yml";
    private final String CONFIG_DIR_NAME = "config";

    public Resource[] getResourceArray() {
        return getResourceArray(PROFILE_CONFIG_PREFIX, PROFILE_CONFIG_SUFFIX);
    }

    public Resource[] getResourceArray(final String profileConfigPrefix, final String profileConfigSuffix) {
        List<Resource> resourceList = new ArrayList<>();

        for (String part : CONFIGS) {
            String fileName = CONFIG_DIR_NAME + '/' + profileConfigPrefix + part + profileConfigSuffix;
            if (ConfigurationFileResourceResolver.class.getClassLoader().getResource(fileName) != null) {
                resourceList.add(new ClassPathResource(fileName));
            }
        }

        return resourceList.toArray(new Resource[resourceList.size()]);
    }
}
