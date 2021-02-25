### STAGE 1: Build ###
FROM node:10-alpine AS build-step
RUN mkdir -p /app
WORKDIR /app
COPY package.json /app
RUN npm install
COPY . /app
RUN npm run build --prod

### STAGE 2: Run ###
FROM nginx:1.17.1-alpine
## Remove default nginx website
RUN rm -rf /usr/share/nginx/html/*
COPY --from=build-step /app/dist/OnlineBookShopFrontEnd /usr/share/nginx/html
COPY ./nginx-custom.conf /etc/nginx/conf.d/default.conf
CMD ["nginx", "-g", "daemon off;"]

