plugins {
    id("java-library")
    id("maven-publish")
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
            artifactId = "micro-service-sso-client"
        }
    }
}