dependencies {
    implementation(project(":micro-service-sso:micro-service-sso-client"))

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}