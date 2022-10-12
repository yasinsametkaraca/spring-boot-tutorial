public class Main {
    public static void main(String[] args) {

        IndividualCustomer yasin =new IndividualCustomer();
        yasin.setCustomerNumber("123");

        CorporateCustomer trendyol = new CorporateCustomer();
        trendyol.setCustomerNumber("124");

        UnionCustomer employeeUnion = new UnionCustomer();  // Yeni bir çalışan türü ekledik ama kodda hiç biryeri bozmadık sadece unionCustomer class ını oluşturduk  (Polimorfizm)
        employeeUnion.setCustomerNumber("125");

        CustomerManager customerManager=new CustomerManager();

       /* customerManager.add(yasin);
        customerManager.add(trendyol);
        customerManager.add(employeeUnion);*/

        Customer[] customers ={yasin,trendyol,employeeUnion};
        customerManager.addMultiple(customers);


    }
}