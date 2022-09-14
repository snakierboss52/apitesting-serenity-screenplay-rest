FROM maven:3.8.1-jdk-11-slim
ARG HOME_DIR="/api-testing"
WORKDIR $HOME_DIR
COPY src /$HOME_DIR/src
COPY pom.xml /$HOME_DIR
ENTRYPOINT ["mvn", "clean", "verify"]

