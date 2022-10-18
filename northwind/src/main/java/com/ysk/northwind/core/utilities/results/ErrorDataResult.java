package com.ysk.northwind.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {


    public ErrorDataResult(T data, String message) {
        super(data, false, message);  //false ise neden hata dönderdik. Çünkü frontend çileri sıkıntıya uğratmamak için.
    }

    public ErrorDataResult(T data) { //mesaj gönderilmek istenmezse
        super(data, false);
    }

    public ErrorDataResult(String message) {  /*sadece mesaj döndermek istersek*/
        super(null, false, message);
    }

    public ErrorDataResult() {  /*sadece true yolladık veri göndermeden*/
        super(null, false);
    }
}
