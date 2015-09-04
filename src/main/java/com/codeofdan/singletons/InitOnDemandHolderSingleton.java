package com.codeofdan.singletons;

public class InitOnDemandHolderSingleton {

    private static class SingletonHolder {
        private static final InitOnDemandHolderSingleton INSTANCE =
                new InitOnDemandHolderSingleton();
    }

    public InitOnDemandHolderSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
