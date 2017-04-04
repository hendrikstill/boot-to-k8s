# Boot-to-k8s-service

This is a simple demo application to show the deployment of a spring-boot application on kubernetes.

## Requirements
* Running Kubernets-Cluster e.g. Minikube
* Java 8
* Docker-Hub login

## Build
```bash
./mvnw clean package

docker build -t hendrikstill/boot-to-k8s-service:v1
```

## Relase
```bash
docker push hendrikstill/boot-to-k8s-service:v1
```
## Deploy
```bash
kubectl create -f k8s-deployment/boot-to-k8s-service.yml
kubectl create -f k8s-deployment/boot-to-k8s-service-deployment.yml
```

## Usage`

### Gets all todos every second
```bash
watch -n 1 curl -s http://192.168.64.8:31613/todo/
```