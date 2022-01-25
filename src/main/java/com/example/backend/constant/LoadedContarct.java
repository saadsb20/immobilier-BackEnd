package com.example.backend.constant;

import contracts.test.ImmobillierContract;

public  class  LoadedContarct {
    private static ImmobillierContract loadedContarct ;


    public static ImmobillierContract getLoadedContarct() {
        return loadedContarct;
    }

    public static void setLoadedContarct(ImmobillierContract loadedContarct) {
        LoadedContarct.loadedContarct = loadedContarct;
    }
}
