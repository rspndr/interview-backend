package io.rspndr.interview.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.mapping.callback.EntityCallbacks;

import java.util.Collections;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class JdbcConfiguration extends AbstractJdbcConfiguration {

    private final EntityCallbacks entityCallbacks;

    @PostConstruct
    void init() {
//        entityCallbacks.addEntityCallback();
    }

    @Override
    protected List<?> userConverters() {
        return Collections.emptyList();
    }
}
