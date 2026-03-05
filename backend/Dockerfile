FROM azul/zulu-openjdk:21-jre
WORKDIR /app
#COPY . .
#RUN ./gradlew build -x test
COPY build/libs/backend-0.0.1-SNAPSHOT.jar /app/backend.jar
ENTRYPOINT ["java","-jar","backend.jar"]