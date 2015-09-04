package com.codeofdan.singletons;

public class LazySingleton {

    private static LazySingleton singleton = null;

    private LazySingleton() {

    }

    public static synchronized LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }

        return singleton;
    }
}
