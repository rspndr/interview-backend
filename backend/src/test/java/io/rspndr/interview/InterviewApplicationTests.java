package io.rspndr.interview;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;
import org.springframework.boot.security.oauth2.client.autoconfigure.OAuth2ClientAutoConfiguration;
import org.springframework.boot.security.oauth2.server.resource.autoconfigure.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@Import({ TestcontainersConfiguration.class, InterviewTestConfiguration.class })
@SpringBootTest
@ActiveProfiles("test")
@EnableAutoConfiguration(exclude = {
		SecurityAutoConfiguration.class,
		OAuth2ClientAutoConfiguration.class,
		OAuth2ResourceServerAutoConfiguration.class
})
class InterviewApplicationTests {

	@Test
	void contextLoads() {
	}

}
