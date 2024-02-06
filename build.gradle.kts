import io.gitlab.arturbosch.detekt.Detekt

plugins {
    id("io.gitlab.arturbosch.detekt") version "1.23.4"
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
    `java-library`
    `maven-publish`
}

group = "xyz.avalonxr"
version = "1.0-SNAPSHOT"

publishing {
    repositories {
        maven {
            name = "Github"
            url = uri("https://maven.pkg.github.com/AvalonXR/OSCSDK-Kotlin")
            credentials {
                username = System.getenv("GH_USERNAME")
                password = System.getenv("GH_TOKEN")
            }
        }
    }

    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}

tasks.jar {
    manifest {
        attributes(mapOf("Implementation-Title" to project.name,
            "Implementation-Version" to project.version))
    }
}

java {
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            version = project.version.toString()
            artifactId = project.name
            groupId = "xyz.avalonxr"
            from(components["java"])
        }
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.4")

    api("com.illposed.osc:javaosc-core:0.8")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
//    implementation("io.ktor:ktor-server-netty:2.3.7")
//    implementation("io.ktor:ktor-server-default-headers:2.3.7")
    // https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
    // implementation("ch.qos.logback:logback-classic:1.4.14")
    // implementation("org.jmdns:jmdns:3.5.9")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}


detekt {
    autoCorrect = true
    buildUponDefaultConfig = true
    allRules = false
    config.setFrom("$projectDir/config/detekt.yml")
    baseline = file("$projectDir/config/baseline.xml")
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = "21"

    reports {
        html.required.set(true)
        xml.required.set(true)
        txt.required.set(true)
        sarif.required.set(true)
        md.required.set(true)
    }
}