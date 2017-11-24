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

## Usage

### test locally with docker run
`docker run --rm -p 8080:8080 hendrikstill/boot-to-k8s-service:v1`
`curl http://localhost:8080/todo`

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
