public class Utils {
    public static void runLoggers(Logger[] loggers,String message) {  //static yaptık çünkü buraya sınıf seviyesinde ulaşıcaz diğer türlü nesne oluşturup dururuz.
        for(Logger logger : loggers) {
            logger.log(message + " Loglandı (ekleme)");
        }
    }

}
