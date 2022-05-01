plugins {
    id("java")
}

group = "net.weavemc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

}

dependencies {
    implementation("org.jetbrains:annotations:23.0.0")
    implementation("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    implementation("com.google.guava:guava:31.1-jre")
    implementation("com.google.code.gson:gson:2.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}