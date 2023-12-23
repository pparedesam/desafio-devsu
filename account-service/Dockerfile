#Genera el dockerfile para dockerizar la aplicacion con java 17
FROM openjdk:17-jdk-alpine
#Crea el directorio de trabajo
WORKDIR /app
#Copia el jar generado en el paso anterior
COPY build/libs/*.jar app.jar

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8081

#Ejecuta el jar
ENTRYPOINT ["java","-jar","app.jar"]

