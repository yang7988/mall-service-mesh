FROM java:8
RUN mkdir -p /data/project
ENV WORK_DIR /data/project
WORKDIR $WORK_DIR
VOLUME $WORK_DIR
COPY mall-gateway.jar $WORK_DIR/mall-gateway.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/data/project/mall-gateway.jar"]