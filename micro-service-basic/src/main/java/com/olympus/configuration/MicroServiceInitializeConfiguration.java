package com.olympus.configuration;

import com.olympus.base.utils.support.globalization.configuration.GlobalizationApplicationConfig;
import com.olympus.base.utils.support.globalization.configuration.GlobalizationAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author eddie.lys
 * @since 2023/4/24
 */
@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "spring.micro-service", name = "enable-auto-config")
public class MicroServiceInitializeConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "spring.micro-service", name = "enable-globalization-center")
    public GlobalizationAutoConfiguration globalizationAutoConfiguration(GlobalizationApplicationConfig globalizationApplicationConfig) {
        return new GlobalizationAutoConfiguration(globalizationApplicationConfig);
    }
}
