public class Product {
    private int id;
    private String name;
    private double unitPrice;
    private String detail;
    private double discount;

    public Product(){  //alt + insert ile otomatik oluşturulabilir
        System.out.println("Constructor");
    }
    public Product(int id, String name, double unitPrice, String detail, double discount){  //constructor = object her oluştuğunda çalışır
        this(); //parametresiz constructor u da çalıştır
        this.id=id;
        this.name=name;
        this.unitPrice=unitPrice;
        this.detail=detail;   //this in anlamı product class ı içindeki demektir.
        this.discount=discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUniPrice() {
        return unitPrice;
    }

    public void setUniPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getUnitPriceAfterDiscount() {
        return this.unitPrice-(this.unitPrice*this.discount/100);
    }


}
