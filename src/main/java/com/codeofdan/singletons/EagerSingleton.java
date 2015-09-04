package com.codeofdan.singletons;

public class EagerSingleton {

    private EagerSingleton() {

    }

    private static final EagerSingleton SINGLETON = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return SINGLETON;
    }
}
