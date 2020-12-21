FROM java:8
RUN mkdir -p /data/project
ENV WORK_DIR /data/project
WORKDIR $WORK_DIR
VOLUME $WORK_DIR
COPY mall-order-service.jar $WORK_DIR/mall-order-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/data/project/mall-order-service.jar"]