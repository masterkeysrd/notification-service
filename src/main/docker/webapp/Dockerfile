FROM node:20.11.1-alpine as BUILDER
WORKDIR /app
COPY package.json package-lock.json tsconfig.json tsconfig.node.json vite.config.ts ./
RUN npm install
COPY ./src/main/webapp ./src/main/webapp
RUN npm run build

FROM nginx:1.25.4-alpine
ENV API_URL=http://localhost:8080
COPY --from=BUILDER /app/dist /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]
