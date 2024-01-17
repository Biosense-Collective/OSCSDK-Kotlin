plugins {
    kotlin("jvm") version "1.9.21"
}

group = "xyz.avalonxr"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.illposed.osc:javaosc-core:local.1.0.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}