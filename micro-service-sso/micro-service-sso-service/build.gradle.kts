plugins {
    id("java")
    id("java-library")
}

dependencies {
    api(project(":micro-service-sso:micro-service-sso-client"))
    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.cloud:spring-cloud-starter-openfeign")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}