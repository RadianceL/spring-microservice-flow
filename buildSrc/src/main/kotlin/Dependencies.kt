object Dependencies {
    const val SPOTLESS_VERSION = "5.0.0"
    const val SPRING_BOOT_VERSION = "3.0.5"
    const val SPRING_DEPENDENCY_MANAGEMENT_VERSION = "1.1.0"
    const val GRAALVM_NATIVE_VERSION = "0.9.20"
    const val MYBATIS_SPRING_BOOT_STARTER_VERSION = "3.0.0"

    object SpringBoot {
        const val WEB = "org.springframework.boot:spring-boot-starter-web"
        const val DATA_JPA = "org.springframework.boot:spring-boot-starter-data-jpa"
    }

    object Mybatis {
        const val MYBATIS_SPRING_BOOT_STARTER = "org.mybatis.spring.boot:mybatis-spring-boot-starter:$MYBATIS_SPRING_BOOT_STARTER_VERSION"
    }
}