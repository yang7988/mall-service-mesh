FROM java:8
RUN mkdir -p /data/project
ENV WORK_DIR /data/project
WORKDIR $WORK_DIR
VOLUME $WORK_DIR
COPY mall-storage-service.jar $WORK_DIR/mall-storage-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/data/project/mall-storage-service.jar"]