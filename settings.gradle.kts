rootProject.name = "spring-microservice-flow"
include("micro-service-router")
include("micro-service-sso")
include("micro-service-sso:micro-service-sso-client")
findProject(":micro-service-sso:micro-service-sso-client")?.name = "micro-service-sso-client"
include("micro-service-sso:micro-service-sso-api")
findProject(":micro-service-sso:micro-service-sso-api")?.name = "micro-service-sso-api"
include("micro-service-sso:micro-service-sso-service")
findProject(":micro-service-sso:micro-service-sso-service")?.name = "micro-service-sso-service"
include("micro-service-sso:micro-service-sso-starter")
findProject(":micro-service-sso:micro-service-sso-starter")?.name = "micro-service-sso-starter"
