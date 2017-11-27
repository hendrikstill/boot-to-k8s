# Boot-to-k8s-service

This is a simple demo application to show the deployment of a spring-boot application on kubernetes.

[![Build Status](https://travis-ci.org/hendrikstill/boot-to-k8s.svg?branch=postgres)](https://travis-ci.org/hendrikstill/boot-to-k8s)

## Requirements
* Running Kubernets-Cluster e.g. Minikube
* Java 8
* Docker-Hub login
* Postgres

## Build
```bash
./mvnw clean package

docker build -t hendrikstill/boot-to-k8s-service:v1
```
## build with docker

`docker run -it --rm -v $PWD/boot-to-k8s:/data openjdk:8-jdk-alpine /bin/ash`
`./mvnw clean package`

afterwards you will see the *target* folder inside the boot-to-k8s folder

## Relase
```bash
docker push hendrikstill/boot-to-k8s-service:v1
```
## Deploy
```bash
kubectl create -f k8s-deployment/boot-to-k8s-service.yml
kubectl create -f k8s-deployment/boot-to-k8s-service-deployment.yml
```

## Usage

### test locally with docker run
`docker run --rm -p 8080:8080 hendrikstill/boot-to-k8s-service:v1`
`curl http://localhost:8080/todo`

### Configure other Database

```bash
docker run --rm -e SPRING_DATASOURCE_URL=jdbc:postgresql://mypostgres:5432/ci_test -p 8080:8080 hendrikstill/boot-to-k8s-service:v1
```

### Gets all todos every second
```bash
watch -n 1 curl -s http://192.168.64.8:31613/todo/
```

### Gets all undone todos every second
```bash
watch -n 1 curl -s http://192.168.64.8:31613/todo/undone
```

### Add a new todo
```bash
curl --request POST \
  --url 'http://localhost:8080/todo' \
  --header 'content-type: application/json' \
  --data '{
		"name": "new test todo"
}'
```
## Start Postgres 
```bash
docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -e POSTGRES_DB=springbootdb -p 5432:5432 -d postgres:9.6
```