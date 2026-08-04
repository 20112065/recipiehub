plugins {
    kotlin("jvm") version "2.3.0"
}

group = "ie.setu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
// dependencies for logging
   implementation("io.github.oshai:kotlin-logging-jvm:8.0.4")
    implementation("org.slf4j:slf4j-simple:2.0.18")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}