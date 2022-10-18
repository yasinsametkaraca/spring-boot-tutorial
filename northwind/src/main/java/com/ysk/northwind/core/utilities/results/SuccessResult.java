package com.ysk.northwind.core.utilities.results;

public class SuccessResult extends Result {//işleri kolaylaştırmak için direk true dönen cevaplar için bu sınıf oluştu.

    public SuccessResult() { /*mesaj vermek istemeyebiliriz*/
        super(true);
    }

    public SuccessResult(String message) {
        super(true,message);
    }



}
