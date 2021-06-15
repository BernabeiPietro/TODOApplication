FROM openjdk:8
ARG jarToCopy
COPY /target/$jarToCopy /app/app.jar

CMD ["java", "-cp", "/app/app.jar", "com.examples.todoapp.TodoApplication"]