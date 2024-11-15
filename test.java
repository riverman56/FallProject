public class Test{

    public static void main(String[] arg){

        FinanceReport bank = new FinanceReport();
        System.out.println("Full Report:\n" + bank);
        bank.addTransaction(true, "initial reserves", 10000, new Date(3,15,2020));
        bank.addTransaction(false, "loans", 9000, new Date(4,1,2020));
        //bank.addTransaction();
        System.out.println("Balance: $" + bank.fullBalance());
        System.out.println("Full Report:\n" + bank);
    }

}