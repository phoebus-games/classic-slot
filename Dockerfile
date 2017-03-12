FROM openjdk:8-jre-alpine
ADD target/classic-slot.jar /
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /classic-slot.jar" ]
