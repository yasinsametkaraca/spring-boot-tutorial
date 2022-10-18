package com.ysk.northwind.core.utilities.results;

public class Result {  //bu katmanda bütün projede ortak kodlar yazılır. Mesela ürün eklemede işlem sonucu true/false yanıtı dönme gidir. Api deki yanıtları girdik.
    private boolean success;
    private String message;

    public Result(boolean success) {  //sadece success bilgisi olabilir yanıtta.
        this.success = success;
    }

    public Result(boolean success, String message) {
        this(success);  //buranın amacı zaten yukarda success in constructor unu ekledik burdan çağırdık.
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
