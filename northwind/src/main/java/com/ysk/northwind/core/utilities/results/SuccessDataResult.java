package com.ysk.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{  //veri ile birlikte yada verisiz her türlü true dönen cevaplar için oluşturduk.

    public SuccessDataResult(T data, String message) {
        super(data,true, message);
    }

    public SuccessDataResult(T data){ //mesaj gönderilmek istenmezse
        super(data,true);
    }

    public SuccessDataResult(String message) {  /*sadece mesaj döndermek istersek*/
        super(null,true, message);
    }
    public SuccessDataResult() {  /*sadece true yolladık veri göndermeden*/
        super(null,true);
    }
}
