public class Main {
    public static void main(String[] args) {

       /* //CustomerManager customerManager = new CustomerManager();  //bu kod yanlış olan
        Customer yasin = new Customer(1,"Yasin Samet","Karaca");
        customerManager.addCustomer(yasin);*/

        /*CustomerManager customerManager = new CustomerManager(new DatabaseLogger()); //Tekli loglama //Örneğin database e değil dosyaya loglamak istiyoruz. Sadece new EmailLogger() ile yaparız. Yani sonradan ekleme olduğunda sadece EmailLogger class ını ekleriz. Kod da değişiklik yapmayız.
        customerManager.addCustomer(new Customer(1,"Yasin Samet","Karaca"));*/

        Logger[] loggers = {new SmsLogger(),new DatabaseLogger()};
        CustomerManager customerManager = new CustomerManager(loggers); /*Çoklu loglama için*/
        customerManager.deleteCustomer(new Customer(1,"Yasin Samet","Karaca"));
    }
}A