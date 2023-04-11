import com.diffplug.gradle.spotless.SpotlessExtension

plugins { // 插件配置
    id("java-library")
    id("com.diffplug.spotless") version "5.0.0"
}

// 定义BOM
dependencies {
    platform("org.springframework.boot:spring-boot-dependencies:3.0.5")
    platform("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.0")
}

allprojects {
    group = "com.olympus"
    version = "1.0.0-SNAPSHOT"

    repositories {
        maven {
            setUrl("https://maven.aliyun.com/repository/public")
        }
        maven {
            credentials {
                username = project.findProperty("aliyun.username") as String?
                password = project.findProperty("aliyun.password") as String?
            }
            setUrl("https://packages.aliyun.com/maven/repository/2078915-release-EdYqod/")
        }
        maven {
            credentials {
                username = project.findProperty("aliyun.username") as String?
                password = project.findProperty("aliyun.password") as String?
            }
            setUrl("https://packages.aliyun.com/maven/repository/2078915-snapshot-FW4VG4/")
        }
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "com.diffplug.spotless" )
    tasks.withType<Test> {
        useJUnitPlatform()
    }

    configure<SpotlessExtension> {
        java {
            googleJavaFormat()
            target("**/*.java")
        }
    }
}