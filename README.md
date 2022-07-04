## Dragon Ball - pong game in JAVA

- pong game in java with java built-in libraries and packages.

## Table of Content


- [Demo](#demo)
- [Folder Structure](#folder-structure)
- [Libraries and Frameworks](#libraries-and-frameworks)
- [Setup and Run](#setup-and-run)

## Demo

![DragonBall GamePlay](demo/gamePlay.png)

## Folder Structure

```
Project
.
├── README.md
└── src/
    ├── AiController.java
    ├── BallController.java
    ├── Constants.java
    ├── KeyEventListener.java
    ├── Main.java
    ├── PlayerController.java
    ├── Shape.java
    ├── Time.java
    └── Window.java

1 directory, 10 files
```

## Libraries and Frameworks

| Name   | Description                                                                                                        |
| ------ | ------------------------------------------------------------------------------------------------------------------ |
| Java   | Java is a widely used object-oriented programming language and software platform that runs on billions of devices. |
| Jframe | JFrame is a top-level container that provides a window on the screen.                                              |

## Setup and Run

```bash
$ cd src

# Linux / MacOS
$ find -name "*.java" > ../sources.txt

:: Windows
> dir /s /B *.java > ../sources.txt

$ cd ..
$ javac -d dist @sources.txt

$ java dist/Main
```
