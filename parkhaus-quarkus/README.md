# Parkhaus Quarkus

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
mvn quarkus:dev
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
mvn quarkus:dev -D debug=5105
```


### Native Image

Die Anwendung kann auch als GraalVM Native Image kompiliert werden. Dies ist im Docker-Image im Ordner `parkhaus-manager/src/docker/Dockerfile.native` umgesetzt.  Allerdings werden Embedded-Datenbank als Native-Image nicht unterstüzt (siehe [Quarkus Datasource Guide](https://quarkus.io/guides/datasource#jdbc-datasource-2)). Dementsprechend benötigen wir eine externe Datenbank, die von der Anwendung genutzt werden kann. Dazu starten wir eine H2-Instanz als zusätzlichen Docker-Container. Das `Dockerfile.native` ist konfiguriert, die externe Datenbank auf Port 1521 zu verwenden. Zusätzlich führen wir die Container in einem eigenen Docker-Network aus.

#### Docker Network anlegen:

```
docker network create native-quarkus
```


#### Image bauen: 

```
cd parkhaus-manager
docker build --file src/docker/Dockerfile.native -t manager-quarkus-native .
```

#### Container starten: 

##### H2-Container

```
docker pull oscarfonts/h2
docker run -d -p 1521:1521 -p 81:81 -e H2_OPTIONS='-ifNotExists' --network native-quarkus  --name quarkus-h2 oscarfonts/h2
```

##### Quarkus-Container

```

docker run -p 8180:8180 --network native-quarkus --name native-quarkus manager-quarkus-native
```

