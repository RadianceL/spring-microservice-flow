import com.diffplug.gradle.spotless.SpotlessExtension

plugins { // 插件配置
    id("java")
    id("com.diffplug.spotless") version "5.0.0"
}
repositories {
    mavenCentral()
}

// 定义BOM
dependencies {
    platform("org.springframework.boot:spring-boot-dependencies:2.5.3")
}

allprojects {
    group = "com.olympus"
    version = "1.0-SNAPSHOT"
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

    repositories { // 子项目使用的仓库
        mavenCentral() // Maven中央仓库
    }

}