plugins {
    // 插件配置
    id("java")
    id("maven-publish")
    id("org.springframework.boot") version Dependencies.SPRING_BOOT_VERSION apply false
    id("io.spring.dependency-management") version Dependencies.SPRING_DEPENDENCY_MANAGEMENT_VERSION
}

subprojects {
    // 为子项目应用插件
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")

    // 为子项目添加依赖
    dependencies{
        compileOnly(Dependencies.Tools.PROJECT_LOMBOK_DEPENDENCIES)
        annotationProcessor(Dependencies.Tools.PROJECT_LOMBOK_DEPENDENCIES)
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
    // 为子项目添加依赖管理
    dependencyManagement{
        dependencies{
            // chaos日志依赖
            dependency(Dependencies.Tools.OLYMPUS_CHAOS_DEPENDENCIES)
            // fastjson依赖
            dependency(Dependencies.Tools.ALIBABA_FASTJSON2_DEPENDENCIES)
            // mybatis依赖
            dependency(Dependencies.Mybatis.MYBATIS_SPRING_BOOT_STARTER)
            dependency(Dependencies.Tools.SHARDING_SPHERE_DEPENDENCIES)
            // 工具包依赖
            dependency(Dependencies.Tools.OLYMPUS_ARTEMIS_VERSION_DEPENDENCIES)
            imports {
                mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
                // spring-cloud-dependencies依赖
                mavenBom(Dependencies.SpringCloud.SPRING_CLOUD_DEPENDENCIES)
                // spring-cloud-alibaba-dependencies依赖
                mavenBom(Dependencies.SpringCloud.SPRING_CLOUD_ALIBABA_DEPENDENCIES)
            }
        }
    }
}

allprojects {
    group = Dependencies.ProjectConfig.APPLICATION_GROUP_NAME
    version = Dependencies.ProjectConfig.APPLICATION_VERSION
    java.sourceCompatibility = JavaVersion.VERSION_17
    java.targetCompatibility = JavaVersion.VERSION_17

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