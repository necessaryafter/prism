plugins {
    id("io.ktor.plugin") version "3.2.2"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.1.10"
}

repositories {
    mavenCentral()
    maven { url = uri("https://packages.confluent.io/maven/") }
}

dependencies {
    implementation("com.google.guava:guava:33.4.8-jre")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
}