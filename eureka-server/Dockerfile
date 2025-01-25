# Temel olarak Java 21 kullanan bir base image seç
FROM eclipse-temurin:21-jdk-alpine

# Uygulamayı çalıştırmak için gerekli olan çalışma dizinini oluştur
WORKDIR /app

# Build edilen JAR dosyasını container'a kopyala
COPY build/libs/eureka-server.jar app.jar

# Container içinde uygulamayı başlat
ENTRYPOINT ["java", "-jar", "app.jar"]
