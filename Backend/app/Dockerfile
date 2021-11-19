FROM openjdk:17-jdk-oraclelinux8

WORKDIR ./
COPY ./build/distributions/app.zip ./app.zip
RUN microdnf install zip unzip -y
RUN unzip app.zip
EXPOSE 7000
ENTRYPOINT ./app/bin/app