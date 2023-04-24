plugins {
    id("java-library")
    id("maven-publish")
}

dependencies {
    api("com.olympus:olympus-chaos-monitor-base-logger")
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
            artifactId = "micro-service-sso-client"
        }
    }
}