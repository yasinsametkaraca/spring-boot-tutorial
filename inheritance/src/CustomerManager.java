public class CustomerManager {  //ekle sil güncelle ara müşteri getir vs. gibi veritabanına erişilen iş kurallarını yazıcaz.

    public void add(Customer customer){
        System.out.println(customer.getCustomerNumber() + " eklendi.");
    }
    public void addMultiple(Customer[] customers){
        for(Customer customer : customers){
            add(customer);
        }
    }
}
