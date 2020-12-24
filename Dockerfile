FROM openjdk:15-jdk-oraclelinux7
VOLUME /tmp
ARG DEPENDENCY=/build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","sk.stasko.userService.UserServiceApplication"]
