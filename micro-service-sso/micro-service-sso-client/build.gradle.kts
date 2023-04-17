plugins {
    id("java")
    id("maven-publish")
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
            artifactId = "spring-microservice-flow-parent"
        }
    }
}