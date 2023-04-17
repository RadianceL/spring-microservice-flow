plugins{
    id("org.springframework.boot") version Dependencies.SPRING_BOOT_VERSION
    id("org.graalvm.buildtools.native") version Dependencies.GRAALVM_NATIVE_VERSION
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}