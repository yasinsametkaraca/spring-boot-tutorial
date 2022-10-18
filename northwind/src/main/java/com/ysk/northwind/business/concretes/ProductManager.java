package com.ysk.northwind.business.concretes;

import com.ysk.northwind.business.abstracts.ProductService;
import com.ysk.northwind.core.utilities.results.DataResult;
import com.ysk.northwind.core.utilities.results.Result;
import com.ysk.northwind.core.utilities.results.SuccessDataResult;
import com.ysk.northwind.core.utilities.results.SuccessResult;
import com.ysk.northwind.dataAccess.absracts.ProductDao;
import com.ysk.northwind.entities.concretes.Product;
import com.ysk.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public DataResult<List<Product>> getAll() {
        //business codes (kurallar mesela bunu listelemek için bazı şeyler gerekiyor.)
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Listed.");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);  //Burayı Pageable a çevirdik. findAll un pageable istediği için yazdık. -1 yazdık çünkü 0 dan başlasın istiyoruz.
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort=Sort.by(Sort.Direction.DESC,"productName"); //artan sırada productName e göre sıralasın.
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Success");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product); //jpa reporisitory de ki hazır metodlar sayesinde save i kullandık.
        return new SuccessResult("Product added successfully");  //veri dönmücez bü yüzden result tan giderek successresult yaptık.
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Data Listed.");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) { //burda getByProductNameAndCategoryId yi düzeltmemize gerek yok burda ki kod sorgu mantığıyla değil sadece isimlendirmedir.
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Listed.");    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data Listed.");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories),"Data Listed.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Data Listed.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Data Listed.");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, String categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId),"Data Listed.");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),"Data Listed.");
    }


    /*@Override
    public List<Product> getAll() {
        return this.productDao.findAll(); //extends JpaRepository yaptığımız için bir sürü hazır metod gelir.
    }*/
}
