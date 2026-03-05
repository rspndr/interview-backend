package io.rspndr.interview;

import org.springframework.boot.SpringApplication;
import org.testcontainers.utility.TestcontainersConfiguration;

public class TestInterviewApplication {

	public static void main(String[] args) {
		SpringApplication.from(InterviewApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
