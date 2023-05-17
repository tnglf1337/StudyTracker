plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"



repositories {
    mavenCentral()
}



dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation ("org.assertj:assertj-core:3.24.2")
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    // https://mvnrepository.com/artifact/rerenderer/rerenderer
    implementation ("com.squareup.okio:okio:3.3.0")
}

tasks.test {
    useJUnitPlatform()
}