package io.rspndr.interview;

import io.rspndr.interview.config.InterviewTestConfiguration;
import io.rspndr.interview.config.TestcontainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@Import({ TestcontainersConfiguration.class, InterviewTestConfiguration.class })
@SpringBootTest
@ActiveProfiles("test")
class InterviewApplicationTests {

	@Test
	void contextLoads() {}
}
