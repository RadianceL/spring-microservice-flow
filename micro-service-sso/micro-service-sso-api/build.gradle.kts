group = "com.olympus"
version = "1.0.0-SNAPSHOT"

dependencies {
    implementation(project(":micro-service-sso:micro-service-sso-service"))

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}