public class SmsLogger implements Logger {  //İmplement etmek demek Logger ı SmsLogger a uyarla demektir. Logger interface olduğundan override edilmek zorunda.

    @Override
    public void log(String message) {
        System.out.println("Sms olarak Loglandı." + message);
    }
}
