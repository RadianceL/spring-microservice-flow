/**
 * 全局版本定义
 */
object Dependencies {
    object ProjectConfig {
        const val APPLICATION_GROUP_NAME = "com.olympus";
        const val APPLICATION_VERSION = "1.0.0-SNAPSHOT";
    }

    const val GRAALVM_NATIVE_VERSION = "0.9.20"
    const val MYBATIS_SPRING_BOOT_STARTER_VERSION = "3.0.0"

    const val ALIBABA_FASTJSON2_VERSION = "2.0.27"
    const val OLYMPUS_CHAOS_VERSION = "1.1.2"
    const val PROJECT_LOMBOK_VERSION = "1.18.26"

    const val SPRING_BOOT_VERSION = "3.0.6"
    const val SPRING_DEPENDENCY_MANAGEMENT_VERSION = "1.1.0"
    const val SPRING_CLOUD_DEPENDENCIES_VERSION = "2022.0.2"
    const val SPRING_CLOUD_DEPENDENCIES_ALIBABA_VERSION = "2022.0.0.0-RC1"

    object Tools {
        const val ALIBABA_FASTJSON2_DEPENDENCIES = "com.alibaba.fastjson2:fastjson2:$ALIBABA_FASTJSON2_VERSION"
        const val OLYMPUS_CHAOS_DEPENDENCIES = "com.olympus:olympus-chaos-monitor-base-logger:$OLYMPUS_CHAOS_VERSION"
        const val PROJECT_LOMBOK_DEPENDENCIES = "org.projectlombok:lombok:$PROJECT_LOMBOK_VERSION"
    }

    object SpringCloud {
        const val SPRING_CLOUD_DEPENDENCIES = "org.springframework.cloud:spring-cloud-dependencies:$SPRING_CLOUD_DEPENDENCIES_VERSION"
        const val SPRING_CLOUD_ALIBABA_DEPENDENCIES = "com.alibaba.cloud:spring-cloud-alibaba-dependencies:$SPRING_CLOUD_DEPENDENCIES_ALIBABA_VERSION"
    }

    object Mybatis {
        const val MYBATIS_SPRING_BOOT_STARTER = "org.mybatis.spring.boot:mybatis-spring-boot-starter:$MYBATIS_SPRING_BOOT_STARTER_VERSION"
    }
}