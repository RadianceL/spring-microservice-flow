object Dependencies {
    const val SPRING_BOOT_VERSION = "2.5.5"
    const val MYBATIS_SPRING_BOOT_STARTER_VERSION = "3.0.0"

    object SpringBoot {
        const val WEB = "org.springframework.boot:spring-boot-starter-web"
        const val DATA_JPA = "org.springframework.boot:spring-boot-starter-data-jpa"
    }

    object Mybatis {
        const val SPRING_BOOT_STARTER = "org.mybatis.spring.boot:mybatis-spring-boot-starter:$MYBATIS_SPRING_BOOT_STARTER_VERSION"
    }
}