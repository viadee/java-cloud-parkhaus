# Parkhaus Micronaut

![Parkhaus Example](../parkhaus.png)

## Getting started

### Local Machine

#### Parkhaus Manager

```
cd parkhaus-manager/
```

##### Build

```
mvn clean install
```

##### Run

```
java -jar target/parkhaus-manager-micronaut-1.0-SNAPSHOT.jar 
```

#### Parkhaus Schranke

```
cd parkhaus-schranke/
```

##### Build

```
mvn clean install
```

##### Run

```
java -jar target/parkhaus-schranke-micronaut-1.0-SNAPSHOT.jar

```


### Native Image

Die Anwendung kann auch als GraalVM Native Image kompiliert werden. Dies ist im Docker-Image im Ordner `parkhaus-manager/src/docker/Dockerfile.native` umgesetzt. 

#### Image bauen: 

```
cd parkhaus-manager
docker build --file src/docker/Dockerfile.native -t manager-micronaut-native .
```

#### Container starten: 

```
docker run -p8280:8280 manager-micronaut-native 
```
