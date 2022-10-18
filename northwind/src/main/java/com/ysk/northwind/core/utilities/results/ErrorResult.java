package com.ysk.northwind.core.utilities.results;

public class ErrorResult  extends Result { //işleri kolaylaştırmak için direk false dönen cevaplar için bu sınıf oluştu.

    public ErrorResult() { /*mesaj vermek istemeyebiliriz*/
        super(false);
    }

    public ErrorResult(String message) {
        super(false,message);
    }
}
