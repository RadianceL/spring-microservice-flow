rootProject.name = "spring-microservice-flow"
include("micro-service-router")
include("micro-service-sso")
include("micro-service-sso:micro-service-sso-client")
findProject(":micro-service-sso:micro-service-sso-client")?.name = "micro-service-sso-client"
