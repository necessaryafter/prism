plugins {
    kotlin("jvm") version "2.1.10"
}

allprojects {
    group = "com.prism"
    version = "0.0.1"

    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
    }

    kotlin {
        jvmToolchain(21)
    }
}