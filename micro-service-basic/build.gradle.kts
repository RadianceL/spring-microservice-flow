plugins {
    id("java-library")
}

dependencies {
    api("com.olympus:olympus-artemis-base:1.0.13")

    implementation("com.alibaba.fastjson2:fastjson2")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}