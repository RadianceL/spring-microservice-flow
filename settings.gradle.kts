rootProject.name = "spring-microservice-flow"
include("micro-service-router")
include("micro-service-basic")
include("micro-service-sso")
include("micro-service-sso:micro-service-sso-client")
include("micro-service-sso:micro-service-sso-api")
include("micro-service-sso:micro-service-sso-service")
include("micro-service-sso:micro-service-sso-starter")
include("micro-service-sso:micro-service-sso-dal")
findProject(":micro-service-sso:micro-service-sso-dal")?.name = "micro-service-sso-dal"
