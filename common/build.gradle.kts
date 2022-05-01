plugins {
    id("java")
}

group = "net.weavemc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    //maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/public/") }
}

dependencies {
    implementation("org.jetbrains:annotations:23.0.0")
    implementation("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    implementation("com.google.guava:guava:31.1-jre")

    //implementation("org.spigotmc:spigot-api:1.18.2-R0.1-SNAPSHOT")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}