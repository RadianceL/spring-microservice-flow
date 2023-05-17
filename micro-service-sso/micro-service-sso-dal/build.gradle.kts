plugins {
    id("java-library")
}

dependencies {
    implementation("com.mysql:mysql-connector-j:8.0.33")
    api("org.mybatis.spring.boot:mybatis-spring-boot-starter")
    api("org.apache.shardingsphere:shardingsphere-jdbc-core-spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}