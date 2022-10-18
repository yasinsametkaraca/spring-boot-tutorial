package com.ysk.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {  //Veri tablosundan veriyi aldınız ve ilgili modelle maplediniz. İlgili modelin veri tablosundan aldığı bilgiyle maplenebilmesi için veri tablosu kolonlarıyla, modelin propertyleri isim ve tip olarak eşleşmeli. Ancak siz bu veriyi modeldeki gibi direkt olarak programınızda kullanmak istemiyor olabilirsiniz. Örneğin veri tabanından çekilen veride isim, soyisim ayrı propertylerdedir. Sizin tek property olarak kullanmanız gerekir ya da iki farklı veri tablosundan maplediğiniz iki modelden gelen propertyleri harmanlayarak bir model oluşturmanız gerekebilir. İşte veri tabanından mapplenen modelleri uygulama içerisinde kullanacağınız modelle aktardığınızda bu modeller dto olarak adlandırılır.
//dto nun mantığı iki tablo arası join atmak. istediğimiz veriyi çekebilmek.
    private int id;
    private String productName;
    private String categoryName;


}
