plugins{
    id("java")
    id("org.springframework.boot") version Dependencies.SPRING_BOOT_VERSION
    id("org.graalvm.buildtools.native") version Dependencies.GRAALVM_NATIVE_VERSION
}

dependencies {
    implementation(project(":micro-service-sso:micro-service-sso-api"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}