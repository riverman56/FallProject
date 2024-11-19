public class Test {
    public static void main(String[] arg) {
        FinanceReport bank = new FinanceReport();
        System.out.println("Full Report:\n" + bank);
        bank.addTransaction(true, "settling debts", 500, new Date(5, 20, 2021));
        bank.addTransaction(true, "initial reserves", 10000, new Date(3, 15, 2020));
        bank.addTransaction(false, "loans", 9000, new Date(4, 1, 2020));
        bank.addRecurring(true, "stock derivitives", 800, new Date(1,1,2020), new Date(6,1,2020), 1);
        bank.addRecurring(false, "car payments", 500, new Date(3,20,2020), new Date(1,20,2021), 1);
        
        System.out.println("Full Report:\n" + bank);
        System.out.println("Balance: $" + bank.fullBalance());
    }
}
