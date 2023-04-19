plugins{
    id("org.springframework.boot") version Dependencies.SPRING_BOOT_VERSION
    id("org.graalvm.buildtools.native") version Dependencies.GRAALVM_NATIVE_VERSION
}

dependencies {
    implementation(project(":micro-service-sso:micro-service-sso-api", ""))
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}