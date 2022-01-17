plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.0"
    java
}

version = "2021.08"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.tinylog:tinylog-api-kotlin:2.4.1")
    implementation("org.tinylog:tinylog-impl:2.4.1")
    implementation("org.jetbrains.kotlin:kotlin-script-runtime:1.6.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

java {
    withSourcesJar()
}

tasks {

    getByName<Test>("test") {
        useJUnitPlatform()
    }

    jar {
        manifest {
            attributes(mapOf("Implementation-Title" to project.name,
                "Implementation-Version" to project.version))
        }
    }

}
