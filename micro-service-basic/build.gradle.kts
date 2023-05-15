plugins {
    id("java-library")
}

dependencies {
    api("com.olympus:olympus-artemis-starter")

    implementation("com.alibaba.fastjson2:fastjson2")
    implementation("org.springframework.boot:spring-boot-starter-security")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}