public class Main {
    public static void main(String[] args) { // bir iş yapan sınıfın içinde başka iş yapan sınıfı new lemek yanlıştır. yani somut sınıflar arası newlemek yanlıştır.

        CustomerManager customerManager = new CustomerManager();
        customerManager.add(new DatabaseLogger());
        customerManager.add(new FileLogger());


    }
}