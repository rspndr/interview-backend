plugins {
	application
}

group = "io.rspndr"
version = "0.0.1-SNAPSHOT"
description = "RSPNDR Interview Project"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.keycloak:keycloak-core:25.0.4")
}
