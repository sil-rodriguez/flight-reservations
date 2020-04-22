docker volume create --name gradle-cache
docker run --rm -v gradle-cache:/home/gradle/.gradle -v "$PWD":/home/gradle/project -w /home/gradle/project gradle:4.7.0-jdk8-alpine gradle build
ls -ltrh ./build/libs