plugins {
    id("org.springframework.boot") version "3.1.3"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    api("org.springframework.boot:spring-boot-starter")
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.jetbrains.kotlin:kotlin-reflect")
    testApi("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("com.h2database:h2:2.1.214")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
