package com.ysk.northwind.business.concretes;

import com.ysk.northwind.business.abstracts.ProductService;
import com.ysk.northwind.dataAccess.absracts.ProductDao;
import com.ysk.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service  //bu classın projede servis görevi göreceğinin bilgisini veriyoruz. Bu classın Business katmanında olduğunu diyoruz kısaca.
public class ProductManager implements ProductService {  //ProductService referansı tutar.

    private ProductDao productDao;/*Dao ya erişmemiz gerekir. Otomatik injection yapar*/
    @Autowired    /*productdao nun instance si olabilecek sınıfı spring otomatik veriyor*/
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return this.productDao.findAll(); //extends JpaRepository yaptığımız için bir sürü hazır metod gelir.
    }
}
