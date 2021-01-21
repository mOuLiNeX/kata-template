import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.kotlin.dsl.*
import org.gradle.kotlin.dsl.support.serviceOf
import org.gradle.api.internal.artifacts.ivyservice.ivyresolve.strategy.VersionSelectorScheme

plugins {
    kotlin("jvm") version "1.4.21"
    application
    jacoco
    id("info.solidsoft.pitest") version "1.5.2"
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
    testImplementation("io.kotest:kotest-runner-junit5:latest.release") // for kotest framework
    testImplementation("io.kotest:kotest-assertions-core:latest.release") // for kotest core jvm assertions
    testImplementation("io.kotest:kotest-property:latest.release") // for kotest property test
    testImplementation("io.mockk:mockk:latest.release")
}

val versionSelectorScheme = serviceOf<VersionSelectorScheme>()
configurations {
    all {
        resolutionStrategy {
            componentSelection {
                all {
                    if (candidate.version.contains("RC") or candidate.version.endsWith("SNAPSHOT")) {
                        allDependencies.find { it.group == candidate.group && it.name == candidate.module }?.let {
                            if (!versionSelectorScheme.parseSelector(it.version).matchesUniqueVersion()) {
                                reject("Only releases are allowed for dynamic versions ($it)")
                            }
                        }
                    }
                }
            }
        }
    }
}

application {
    mainClass.set("MainKt")
}