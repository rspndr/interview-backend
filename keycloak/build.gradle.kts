plugins {
	application
}

group = "io.rspndr"
version = "0.0.1-SNAPSHOT"
description = "RSPNDR Interview Project"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.keycloak:keycloak-core:26.7.0")
}
