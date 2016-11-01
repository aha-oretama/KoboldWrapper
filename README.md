# KoboldWrapper

Java Library for [kobold](https://github.com/yahoo/kobold).

## Usage

### Install kobold

KoboldWrapper is Java library of [kobold](https://github.com/yahoo/kobold) which is image comparing library for npm.
Therefore, install kobold in your environment before using KoboldWrapper.

### Add your pom.xml

Add following in your pom.xml.

```
    <repositories>
        <repository>
            <id>aha-oretama.jp</id>
            <url>https://raw.github.com/aha-oremama/KoboldWrapper/mvn-repo/</url>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>aha-oretama.jp</groupId>
            <artifactId>KoboldWrapper</artifactId>
            <version>0.0.1</version>
        </dependency>
    </dependencies>
```


### Run with Command

```
    Kobold kobold = new KoboldWrapper()
        .approved("approvedFolder")
        .build("buildFolder")
        .highlight("highlightFolder")
        .config("configFolder")
        .failOrphans()
        .failAdditios()
        .run("targetFolder")

    > "kobold --approved-folder approvedFolder --build-folder buildFolder --highlight-folder highlightFolder --config-folder configFolder --fail-orphans --fail-additions
```


