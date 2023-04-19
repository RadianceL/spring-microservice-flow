plugins {
    id("java-library")
}

dependencies {
    api(project(":micro-service-sso:micro-service-sso-client"))

    api("com.alibaba.fastjson2:fastjson2")
    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.cloud:spring-cloud-starter-openfeign")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}