package com.codeofdan.hello;

/**
 * Simple Object-orientated take on Hello World.
 */
public class HelloWorld {

    private String name;

    public HelloWorld(String name) {
        this.name = name;
    }

    public HelloWorld() {
        this("World");
    }

    public void sayHello() {
        System.out.println("Hello " + name + "!");
    }

    public static void main(String[] args) {
        HelloWorld helloWorld;

        if (args.length > 0) {
            helloWorld = new HelloWorld(args[0]);
        } else {
            helloWorld = new HelloWorld();
        }

        helloWorld.sayHello();
    }

}