plugins{
    java
    id("org.springframework.boot") version Dependencies.SPRING_BOOT_VERSION
    id("org.graalvm.buildtools.native") version Dependencies.GRAALVM_NATIVE_VERSION
}

graalvmNative {
    binaries {
        named("main") {
            mainClass.set("com.olympus.RouterApplication")
            buildArgs.addAll("--initialize-at-run-time=ch.qos.logback.classic.Logger", "--no-fallback","--trace-object-instantiation=ch.qos.logback.classic.Logger")
        }
    }
}

dependencies {
    implementation(project(":micro-service-sso:micro-service-sso-client"))

    implementation("com.alibaba.fastjson2:fastjson2")
    implementation("com.olympus:olympus-chaos-monitor-base-logger")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
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