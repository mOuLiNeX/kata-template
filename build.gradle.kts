import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.20"
    application
    jacoco
    id("info.solidsoft.pitest") version "1.5.1"
}

group = "kata"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    jcenter()
}

tasks {

    withType<KotlinCompile>() {
        kotlinOptions.jvmTarget = "11"
    }

    named<Wrapper>("wrapper") {
        distributionType = Wrapper.DistributionType.BIN
    }

    withType<Test> {
        useJUnitPlatform()
    }

    jacocoTestReport {
        dependsOn(test) // tests are required to run before generating the report
    }

    configure<info.solidsoft.gradle.pitest.PitestPluginExtension> {
        junit5PluginVersion.set("0.12")
        avoidCallsTo.set(setOf("kotlin.jvm.internal"))
        mutators.set(setOf("STRONGER"))
        threads.set(2)
        outputFormats.set(setOf("HTML"))
    }
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:4.+") // for kotest framework
    testImplementation("io.kotest:kotest-assertions-core:4.+") // for kotest core jvm assertions
    testImplementation("io.kotest:kotest-property:4.+") // for kotest property test
}

application {
    mainClass.set("MainKt")
}