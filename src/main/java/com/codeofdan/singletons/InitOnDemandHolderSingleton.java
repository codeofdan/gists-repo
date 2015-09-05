package com.codeofdan.singletons;

public class InitOnDemandHolderSingleton {

    private InitOnDemandHolderSingleton() {

    }

    private static class SingletonHolder {
        private static InitOnDemandHolderSingleton INSTANCE;

        static {
            try {
                INSTANCE = new InitOnDemandHolderSingleton();
            } catch (Exception e) {
                INSTANCE = null;
            }
        }
    }

    public static InitOnDemandHolderSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
