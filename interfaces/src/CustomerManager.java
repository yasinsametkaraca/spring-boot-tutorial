public class CustomerManager {
    //birden fazla log yollanırsa
    private Logger[] loggers;   //Neye bağımlıysak onun private değişkenini oluştururuz.

    public CustomerManager(Logger[] loggers) {
        this.loggers = loggers;
    }

    public void addCustomer(Customer customer) {
        System.out.println("Müşteri eklendi " + customer.getFirstName());
        /*for(Logger logger : loggers) {  //hep aynı kodu yazmaktansa ayrı util diye sınıf oluşturup ordan çağırdık static metod yaptıkki direk çağıralım
            logger.log(customer.getFirstName()+ " Loglandı (ekleme)");
        }*/
        Utils.runLoggers(loggers, customer.getFirstName());  //static yaparak direk Utils. diyerek çağırdık. Static ler bir kez oluşur bellekte orda kalır. Static olmayanlar kullan temizle olurlar.

    }
    public void deleteCustomer(Customer customer) {
        System.out.println("Müşteri silindi " + customer.getFirstName());
        /*for(Logger logger : loggers) {
            logger.log(customer.getFirstName()+ " Loglandı (silme)");
        }*/
        Utils.runLoggers(loggers, customer.getFirstName());  //static yaparak direk Utils. diyerek çağırdık
    }



        //Tek log yollanırsa
   /* public void  addCustomer(Customer customer) {  //Bu yorum satırı tarzında kod yazmak yanlıştır. Çalışır ama çok fazla kod yazmak zorundayız. CustomerManager de sadece müşteriyi ilgilendiren kodlar olmalı.
        System.out.println("Müşteri eklendi" + customer.getFirstName());
        DatabaseLogger logger =  new DatabaseLogger();   //Bir sürü yerden kullanıcaz her yerde new mi yapıcaz çok saçma olur.
        logger.log(customer.getFirstName()+ "Veritabanına loglandı.(Ekleme)");
    }
    public void deleteCustomer(Customer customer) {
        System.out.println("Müşteri silindi" + customer.getFirstName());
        DatabaseLogger logger = new DatabaseLogger();
        logger.log(customer.getFirstName()+ "Veritabanına loglandı.(Silinme)");
    }*/

    /*private Logger logger;   //Neye bağımlıysak onun private değişkenini oluştururuz.

    public CustomerManager(Logger logger) {
        this.logger = logger;
    }

    public void addCustomer(Customer customer) {
        System.out.println("Müşteri eklendi " + customer.getFirstName());

        this.logger.log(customer.getFirstName()+ " Loglandı (ekleme)");
    }
    public void deleteCustomer(Customer customer) {
        System.out.println("Müşteri silindi " + customer.getFirstName());

        this.logger.log(customer.getFirstName()+ " Loglandı (silme)");
    }*/



}
