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

Die Anwendung kann auch als GraalVM Native Image kompiliert werden. Dies ist im Docker-Image im Ordner `parkhaus-manager/src/docker/Dockerfile.native` umgesetzt.  Allerdings werden Embedded-Datenbank als Native-Image nicht unterstüzt (siehe [Quarkus Datasource Guide](https://quarkus.io/guides/datasource#jdbc-datasource-2)). Dementsprechend benötigen wir eine externe Datenbank, die von der Anwendung genutzt werden kann. Dazu starten wir eine H2-Instanz als zusätzlichen Docker-Container. Das `Dockerfile.native` ist so konfiguriert, dass die externe Datenbank-URL beim Container-Start mitgegeben werden kann (siehe [Quarkus-Container starten](#####Quarkus-Container)). Zusätzlich führen wir die Container in einem eigenen Docker-Network aus.


#### Image bauen: 

```
cd parkhaus-manager
mvn package -Pnative -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true
```

#### Docker Network anlegen:

```
docker network create native-quarkus
```

#### Container starten: 

##### H2-Container

```
docker pull oscarfonts/h2
docker run -d -p 1521:1521 -p 81:81 -e H2_OPTIONS='-ifNotExists' --network native-quarkus  --name quarkus-h2 oscarfonts/h2
```

##### Quarkus-Container

```
docker run -i -p 8181:8181 --network native-quarkus $USER/parkhaus-manager-quarkus:1.0 "-Dquarkus.datasource.jdbc.url=jdbc:h2:tcp://quarkus-h2:1521/test"
```

