public class Test {
    public static void main(String[] arg) {
        FinanceReport bank = new FinanceReport();
        System.out.println(bank);
        System.out.println("hi");
        bank.addTransaction(true, "initial reserves", 10000, new Date(3, 15, 2020));
        // bank.addTransaction();
        // bank.addTransaction();
    }
}