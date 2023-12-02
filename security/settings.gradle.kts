buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("com.palantir.javaformat:gradle-palantir-java-format:2.38.0")
    }
}

rootProject.name = "demo"
