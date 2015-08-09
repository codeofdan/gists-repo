# Gists repo

This repository is home to all the source files to gists written in posts for [codeofdan.com](http://codeofdan.com)

Writing code in this repo makes it easier to develop and test in an IDE. Individual files are then uploaded as a separate gist once they are completed. Each "project" should only be one file so they can be easily run and compiled.

## Usage

Each class should be compilable by itself, for example to compile the, "Hello World" example you would do the following:

    $ cd src/main/java/
    $ javac com/codeofdan/hello/HelloWorld.java

The source has now been compiled and you can run it as so:

    $ java com.codeofdan.hello.HelloWorld
    Hello World!

An argument can be added to customise the greeting:

    $ java com.codeofdan.hello.HelloWorld Dan
    Hello Dan!


