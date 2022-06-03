# Maven Builder client
Client for [maven-builder](https://github.com/krifle/mvn-builder) project

## Build
```
$ mvn clean package -DskipTests 
```

## Example Usage
```bash
java -jar consoleApp-1.0-SNAPSHOT.jar \
    'http://localhost:8080' \
    'https://github.com/krifle/mvn-builder' \
    'master' \
    'clean package -DskipTests' \
    'target/mvn-builder-0.0.1-SNAPSHOT.jar'
```
