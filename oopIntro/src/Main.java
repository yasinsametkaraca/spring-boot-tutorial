public class Main {
    public static void main(String[] args) {
        /*Product product1 = new Product();
        product1.id = 1;
        product1.name= "Samsung s7";
        product1.uniPrice=1000;
        product1.detail = "işlemci ....";

        Product product2 = new Product();
        product2.id = 2;
        product2.name= "Samsung s8";
        product2.uniPrice=1000;
        product2.detail = "işlemci ....";*/

        Product product3 = new Product(3,"Samsung s9",1000,"İşlemci ....",10 );
        product3.setId(2);
        System.out.println(product3.getUnitPriceAfterDiscount());


        Product[] products = {product3};
        System.out.println(products.length);

        for(Product product:products){  //foreach

            System.out.println(product.getName());
        }

        Category category1= new Category();
        category1.setId(1);
        category1.setName("phone");

        Category category2= new Category();
        category2.setId(2);
        category2.setName("tv");

        System.out.println(category2.getName());

        ProductManager productManager = new ProductManager();
        productManager.addToCart(product3);
    }

}