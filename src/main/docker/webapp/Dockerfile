FROM node:20.11.1-alpine as BUILDER
WORKDIR /app
COPY package.json package-lock.json tsconfig.json tsconfig.node.json vite.config.ts ./
RUN npm install
COPY ./src/main/webapp ./src/main/webapp
RUN npm run build

FROM nginx:1.25.4-alpine
COPY --from=BUILDER /app/dist /usr/share/nginx/html
