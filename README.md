# mylab repository

## Status

![Github CI](https://github.com/butcherless/mylab/workflows/CI/badge.svg)

# Proof of concept and research with colleagues and friends.

- Java 21
- Spring Boot 3

## New project basic structure

Check Java and Maven versions:

    mvn -v
    
```bash
mkdir my-multi-module-project
mvn archetype:generate -DgroupId=dev.cmartin -DartifactId=learn-spring-cloud -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
mvn archetype:generate -DgroupId=dev.cmartin -DartifactId=microservice-one -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
mkdir -p src/{main,test}/{java,resources} src/main/java/com/cmartin/learn
```
