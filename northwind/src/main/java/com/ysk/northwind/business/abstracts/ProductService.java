package com.ysk.northwind.business.abstracts;

import com.ysk.northwind.core.utilities.results.DataResult;
import com.ysk.northwind.core.utilities.results.Result;
import com.ysk.northwind.entities.concretes.Product;
import com.ysk.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();  //liste ile birlikte success ve message da dödürmek için böyle kullandık.
    DataResult<List<Product>> getAll(int pageNo,int pageSize);  //Ürünleri bize veritabanında id sine göre sıralı şekilde getiricek hemde istediğimiz ürün kadar. Şu sayfadaki 10 ürünü getir.
    DataResult<List<Product>> getAllSorted();  //datayı istediğimiz şarta göre sıralasın.
    Result add(Product product); //ekleme

    DataResult<Product> getByProductName(String productName); //buraya dataAccess da yazdıklarımızı DataResult ile yazıyoruz.
    DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);
    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>>getByNameAndCategory(String productName, String categoryId); //kendi sorgumuzu yapıyoruz.

    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();


}
