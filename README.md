
====================================Dockerfile for OnlineBookShopFrontEnd===============================
### STAGE 1: Build ###
FROM node:latest AS build-step
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod

### STAGE 2: Run ###
FROM nginx:latest
COPY --from=build-step /app/dist/OnlineBookShopFrontEnd /usr/share/nginx/html
COPY ./nginx-custom.conf /etc/nginx/conf.d/default.conf
# When the container starts, replace the env.js with values from environment variables
ENTRYPOINT ["/bin/sh",  "-c",  "envsubst < /usr/share/nginx/html/assets/env.template.js > /usr/share/nginx/html/assets/env.js && exec nginx -g 'daemon off;'"]

================================================================================

=======================================Dockerfile for OnlineBookshopBackend========
FROM adoptopenjdk/openjdk11:jdk-11.0.9.1_1
VOLUME ["/tmp"]
COPY target/OnlineBookShopBackEnd-*.jar OnlineBookShopBackEnd.jar
COPY src/ src
COPY pom.xml pom.xml
COPY Dockerfile Dockerfile
ENTRYPOINT ["java","-jar","OnlineBookShopBackEnd.jar"]

==============================================================================
=====================Deployment yaml for FrontEnd============================
####################################################
#  OnlineShop FrontEnd Deployment
####################################################
apiVersion: apps/v1
kind: Deployment
metadata:
  name: onlineshop-frontend
spec:
  replicas: 1
  selector:
    matchLabels:
      app: onlineshop-frontend
  template:
    metadata:
      labels:
        app: onlineshop-frontend
    spec:
      containers:
      - name: onlineshop-frontend
        image: adithilokhande/onlinebookshopfrontend:v2
        imagePullPolicy: Always
        resources:
          limits:
            memory: 512Mi
            cpu: "1"
          requests:
            memory: 256Mi
            cpu: "0.2"  
        ports:
        - containerPort: 8080
        env:
          - name: API_URL
            value: http://34.121.0.201:8181/onlineshop/books
              
---

####################################################
# OnlineShop Backend Service
####################################################
apiVersion: v1
kind: Service
metadata:
  name: onlineshop-frontend
spec:
  selector:
    app: onlineshop-frontend

  ports:
  - port: 80
    protocol: TCP
    targetPort: 80
  type: LoadBalancer
==========================================================================
==========================Depoyement yaml for Backend=====================
####################################################
#  OnlineShop BackEnd Deployment
####################################################
apiVersion: apps/v1
kind: Deployment
metadata:
  name: onlineshop-backend
spec:
  replicas: 1
  selector:
    matchLabels:
      app: onlineshop-backend
  template:
    metadata:
      labels:
        app: onlineshop-backend
    spec:
      containers:
        - name: onlineshop-backend
          image: adithilokhande/onlinebookshopbackend:0.0.1-SNAPSHOT
          imagePullPolicy: Always
          resources:
            limits:
              memory: 512Mi
              cpu: "1"
            requests:
              memory: 256Mi
              cpu: "0.2"  
          ports:
            - containerPort: 8181
              protocol: TCP
      terminationGracePeriodSeconds: 30

---
####################################################
# OnlineShop Backend Service
####################################################
apiVersion: v1
kind: Service
metadata:
  name: onlineshop-backend

spec:
  ports:
    - port: 8181
      protocol: TCP
      targetPort: 8181
  selector:
    app: onlineshop-backend
  type: LoadBalancer  
  ===================================================
  