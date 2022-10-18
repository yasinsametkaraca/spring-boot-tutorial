package com.ysk.northwind.dataAccess.absracts;

import com.ysk.northwind.entities.concretes.Product;
import com.ysk.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//jpa code first çalışır yani elimizde veritabanı olmasaydı bile o bizim sistemimize göre oluştururdu.
public interface ProductDao extends JpaRepository<Product,Integer> {  //@entity ile yazılan yer için=Product, primary key için integer yazdık. Hangi tabloya (product) hangi id (int) veritipiyle sorguların hazırlanması gerektiğini repository e söylüyoruz.
//jparepository bize veritabanından ver sil güncelle gibi şeyleri yapmamızı sağlar

    /*jparepository de tam olarak hazır olmayanları bu satırın altında tanımlamamız gerekir. mesela bir alana göre datayı getirmek. Yinede jpa repository yazdığımız metod ismine göre bize kolaylık sağlar.*/
    Product getByProductName(String productName);  //burada otomatik olarak getByProductName ın adına bakar getBy ı görür ilgili kolona göre(productName) where koşulu getiriyor. (getBy ile başlamak önemlidir. Bu metoda göre Product name e göre verileri çekeriz. )
    Product getByProductNameAndCategory_CategoryId(String productName,int categoryId); // burada bizim yerimize and operatörü olan where koşul yazılır. (spring bunları otomatik yapar) Product taki oluşturduğumuz private Category category üzerinden  categorId ye ulaşır.
    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId); //aynı mantıkla productName veya categoryId si uyanı getirir. Category yazınca ordaki primary key olan categoryId ye göre sorgu olur.
    List<Product> getByCategoryIn(List<Integer> categories); //sql de  ki in komutu. Çoklu category getirmek için.
    List<Product> getByProductNameContains(String productName); //gönderilen parametre ürün adını içeriyorsa onları getir.
    List<Product> getByProductNameStartsWith(String productName);  //gönderilen parametre ile başlıyorsa getir.

    @Query("From Product where productName=:productName and category.categoryId=:categoryId") //Entitydeki isimlere göre yazılır. Veritabanı isimlerine göre yazılmaz.
    List<Product> getByNameAndCategory(String productName, String categoryId); //kendi sorgumuzu yapıyoruz.

    @Query("Select new com.ysk.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p")  //bu satırın mantığı ProductWithCategoryDto'a From dan sonraki yazdığımız sorguyu aktarmak. Bu 3 alanı (p.id,p.productName,c.categoryName) ProductWithCategoryDto' a aktar.  //select p.product_id,p.product_name, c.category_name,p.unit_price from products p inner join categories c on p.category_id =c.category_id
    List<ProductWithCategoryDto> getProductWithCategoryDetails();  //Dto oluşturup bu tarz detay tablolarını oluşturabiliriz.
}
//Category c Inner Join c.products p kodunun mantığı = Category ile category classın da tanımladığımız products' ın colonları ile bağlantı kur. (Category classının içinde private List<Product> products; vardır ordan geliyor.) category id' ye göre inner join yapılıyor.