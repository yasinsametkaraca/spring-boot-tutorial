public class CustomerManager {
   /* public void add(){  // bir iş yapan sınıfın içinde başka iş yapan sınıfı new lemek yanlıştır. yani somut sınıflar arası newlemek yanlıştır.
        System.out.println("Müşteri eklendi");
        DatabaseLogger logger = new DatabaseLogger();
        logger.log();
    }*/

    public void add(Logger logger) {  //3 tarz loglamayı (database,file,email) da alabiliriz

        System.out.println("Müşteri eklendi");
        logger.log();

    }
}

