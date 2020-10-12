## Message Producer

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

### Purpose
1. Ingest events from event producer via HTTP
2. Put ingested events to a Kafka topic 

### To Do's
1. Develop tests
2. Investigate more performant message production (KafkaProducer) 

### Running the application in dev mode
Before you run dev mode start the Kafka broker. You can use the docker-compose
script in the scripts directory and the parent root of this project:
```
docker-compose -f kafka-zookeeper-compose.yml up
```
 
You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

After the application is running in dev mode start the event generator by
executing the events.sh script from the scripts directory:
```
./events.sh
```

Messages will start to accumulate on the events topic in Kafka. You can view them
with various tools like KaDeck Desktop (https://www.getkadeck.com/#/?tab=desktop).

To stop the events ctrl-c in the events shell terminal. To shut down the 
Kafka broker ctrl-c in the terminal where you started the broker or from
a different terminal:
```
docker-compose -f kafka-zookeeper-compose.yml stop
``` 

### Options to package the application for deployment

#### Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `code-with-quarkus-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it?s not an _?ber-jar_ as the dependencies are copied into the `target/lib` directory.
If you want to build an _?ber-jar_, just add the `--uber-jar` option to the command line:
```shell script
./mvnw package -PuberJar
```

The application is now runnable using `java -jar target/code-with-quarkus-1.0.0-SNAPSHOT-runner.jar`.

#### Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.


