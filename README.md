# spring-native

spring native demo

Demo project using spring boot 3.0.0 with native build

Commands 

````shell

mvn clean -Pnative -DskipTests native:compile

````

````shell

docker build -f Dockerfiles/Dockerfile -t feralfeld/jibber-benchmark:native.0.0.1-SNAPSHOT -m 6g .

````
