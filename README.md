# template-spring
spring template for microservices

# jenkins config
1. add user of docker hub to jenkins vault by go to docker.io to generate one-time password for username: champillon
2. add ssh pipeline & docker pipeline & Snyk Security plugin
3. add snyk api token from snyk.io

# maven command
1. run spring-boot
```
mvn spring-boot:run
```

# setup prometheus docker
1. pull docker image
```
docker pull prom/prometheus
```

2. run prometheus image
```
docker run -d --name=prometheus -p 9090:9090 -v [path toprometheus.yml]:/etc/prometheus/prometheus.yml prom/prometheus --config.file=/etc/prometheus/prometheus.yml
```