plugins {
    // 插件配置
    id("java")
    id("maven-publish")
    id("com.diffplug.spotless") version Dependencies.SPOTLESS_VERSION
    id("io.spring.dependency-management") version Dependencies.SPRING_DEPENDENCY_MANAGEMENT_VERSION
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
            artifactId = "spring-microservice-flow-parent"
        }
    }
}

subprojects {
    // 为子项目应用插件
    apply(plugin = "java")
    apply(plugin = "com.diffplug.spotless" )
    apply(plugin = "io.spring.dependency-management")

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    // 为子项目添加依赖
    dependencies{
        compileOnly("org.projectlombok:lombok:1.18.26")
        annotationProcessor("org.projectlombok:lombok:1.18.26")
    }

    // 为子项目添加依赖管理
    dependencyManagement{
        dependencies{
            dependency(Dependencies.Tools.ALIBABA_FASTJSON2_DEPENDENCIES)
            // mybatis依赖
            dependency(Dependencies.Mybatis.MYBATIS_SPRING_BOOT_STARTER)
            imports {
                // spring-cloud-dependencies依赖
                mavenBom(Dependencies.SpringCloud.SPRING_CLOUD_DEPENDENCIES)
                // spring-cloud-alibaba-dependencies依赖
                mavenBom(Dependencies.SpringCloud.SPRING_CLOUD_ALIBABA_DEPENDENCIES)
            }
        }
    }

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