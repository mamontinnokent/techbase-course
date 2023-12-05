plugins {
    java
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.diffplug.spotless") version "6.15.0"
}

group = "ru.security.demo"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}


dependencies {
    implementation("org.springdoc:springdoc-openapi-ui:1.7.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("org.json:json:20210307")

    implementation("io.jsonwebtoken:jjwt-api:0.12.3")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.3")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.3")

    implementation("io.swagger:swagger-core:1.6.12")
    implementation("io.swagger.core.v3:swagger-annotations:2.2.19")
    implementation("io.swagger:swagger-models:1.6.12")

    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.h2database:h2")

    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}


spotless {
    java {
        target("src/main/java/**/*.java", "src/main/test/**/*.java")
        toggleOffOn()
        removeUnusedImports()

        palantirJavaFormat()

        importOrder("#", "com.rbiedrawa", "java", "javax", "")
    }
    json {
        target("**/*.json")
        simple()
        targetExclude(".idea/**/*.json", "out/**/*.json")
    }
    format("misc") {
        target("**/.gitignore", "**/*.gradle", "**/*.md", "**/*.sh")
        indentWithTabs()
        trimTrailingWhitespace()
        endWithNewline()
    }
}


