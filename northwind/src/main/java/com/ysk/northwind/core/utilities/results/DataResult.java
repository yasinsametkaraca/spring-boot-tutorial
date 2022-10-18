package com.ysk.northwind.core.utilities.results;

public class DataResult<T> extends Result{  //bu classta success vesaire birde data döndereceğiz bu veri ürün listesi kategori vs. olabilir bu yüzden generic yapı yaptık.

    private T data;  //mesela productService.getAll()

    public DataResult(T data, boolean success, String message) {
        super(success, message);
        this.data = data;
    }
    public DataResult(T data, boolean success) {  //mesaj geçmek istemeyebiliriz.
        super(success);
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
