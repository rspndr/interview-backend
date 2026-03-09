package io.rspndr.interview.service;

import io.rspndr.interview.config.InterviewTestConfiguration;
import io.rspndr.interview.config.TestcontainersConfiguration;
import io.rspndr.interview.model.Assignment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Import({
        TestcontainersConfiguration.class,
        InterviewTestConfiguration.class,
        DefaultAssignmentService.class
})
@SpringBootTest
@ActiveProfiles("test")
public class DefaultAssignmentServiceIntegrationTests {

    @Autowired
    DefaultAssignmentService service;

    @Test
    public void smokeTest() {
        assertThat(service).isNotNull();
    }

    @Test
    void createAssignment_successfully_saves() {
        // Arrange
        var assignment = Assignment.builder()
                .createdAt(Instant.now())
                .name("Test Assignment")
                .companyCode("ALPHA")
                .location(List.of(40.7128, -74.0060))
                .build();

        // Act
        var saved = service.create(assignment);

        // Assert
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getCreatedAt()).isEqualTo(assignment.getCreatedAt());
        assertThat(saved.isDeleted()).isFalse();
    }
}
