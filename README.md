[![Build Status](https://travis-ci.org/ZgzInfinity/Conversimg.svg?branch=master)](https://travis-ci.org/ZgzInfinity/Conversimg)
[![License: LGPL v3](https://img.shields.io/badge/License-LGPL%20v3-blue.svg)](https://www.gnu.org/licenses/lgpl-3.0)
[![made-with-java](https://img.shields.io/badge/Made%20with-java-e01250.svg)](https://www.java.com/es/download/)
[![made-with-java](https://img.shields.io/badge/Windows%20-compatible-1df31a.svg)](https://www.java.com/es/download/)
[![made-with-java](https://img.shields.io/badge/Mac%20-compatible-1df31a.svg)](https://www.java.com/es/download/)
[![made-with-java](https://img.shields.io/badge/Linux%20-compatible-1df31a.svg)](https://www.java.com/es/download/)


# Conversimg
An open-source image converter and resizer


## 1 - Description

Conversimg is **an open-source command interpreter program** whose purpose is to allow the user to convert and resize images 
locally without having to resort to external services on the Internet.


## 2 - Supported formats

Conversimg works with the most standardized image formats. The supported formats are the following:

* BMP (Windows bitmap).
* JPG (Joint Photographic Experts Group).
* GIF (Graphic Interchange Format).
* PNG (Portable Network Graphics).

More formats will be added in later versions.


## 3 - Source code

The application has been developed in a **gradle project (version 5.6.2)** in **java programming language**. The application has
three files written in java to model the converter, the resizer and the main control module. The files are documented to make 
them as easy to understand as possible.


## 4 - How to compile

In order to compile and make use of the application you must install a gradle version on your computer. The following describes 
how to compile and execute the project.

* To be able to compile the project:

```
gradle assemble
```

* To be able to execute the unitary tests:

```
gradle test
```

* To be able to execute the above two commands in one

```
gradle build
```

If you want to **generate an executable** for your system **you must modify the file gradle.build** and indicate the
corresponding command to be able to achieve it.


## 5 - Compatibility 

The application runs on the following operating systems:

* Windows (all versions).
* Linux (all distributions).
* Mac.

**The only requirement is to have gradle installed**.


## 6 - Continuous integration

The application has been built, as well as its future versions using continuous integration. Travis has been used for this. The
set of tasks you have to execute are in the file **.travis.yml**. Apart from compiling the project, a set of unit tests in java
have been provided to prove that image format validation, conversion and resizing work well. In order to test the resizing and 
conversion of images, a folder has been provided, called **Images**, where four images are found in the four possible formats
for now.

## 7 - How to execute?

Commands to run the program are shown below:

* To convert an image to another format:

```
./Conversing> <-c> <input_image_path> <output_image_path> <output_format>

```

* To resize an image:

```
./Conversing> <-r> <input_image_path> <input_image_path> <percent>
```

## 8 - Release

Currently in development but will provide one executable for Windows and another for Linux.






