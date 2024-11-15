import java.util.Stack;

public class FinanceReport {
    private Stack<Transaction> portfolio;

    public FinanceReport() {
        portfolio = new Stack<>();
    }

    public void addTransaction(Transaction transaction) {
        portfolio.push(transaction);
    }

    public void addTransaction(boolean isDeposit, String category, double amount, Date date) {
        addTransaction(new Transaction(isDeposit, category, amount, date));
    }

    public double fullBalance() {
        return partialBalance(00, 00, 0000, 99, 99, 9999);
    }

    public void fullReport() {
        partialReport(00, 00, 0000, 99, 99, 9999);
    }

    public void partialReport(Date date1, Date date2) {
        Stack<Transaction> temp = new Stack<>();
        while (!portfolio.isEmpty()) {
            Transaction transaction = portfolio.pop();

            if (transaction.getDate().compare(date1) && date2.compare(transaction.getDate()))
                System.out.println(transaction);

            temp.push(transaction);
        }

        while (!temp.isEmpty())
            portfolio.push(temp.pop());
    }

    public void partialReport(int mm1, int dd1, int yyyy1, int mm2, int dd2, int yyyy2) {
        partialReport(new Date(mm1, dd1, yyyy1), new Date(mm2, dd2, yyyy2));
    }

    public double partialBalance(Date date1, Date date2) {
        Stack<Transaction> temp = new Stack<>();
        double total = 0.0;
        while (!portfolio.isEmpty()) {
            Transaction transaction = portfolio.pop();

            if (transaction.getDate().compare(date1) && date2.compare(transaction.getDate())) {
                if (transaction.getIsDeposit())
                    total += transaction.getAmount();
                else
                    total -= transaction.getAmount();
            }

            temp.push(transaction);
        }
        while (!temp.isEmpty())
            portfolio.push(temp.pop());

        return total;
    }

    public double partialBalance(int mm1, int dd1, int yyyy1, int mm2, int dd2, int yyyy2) {
        return partialBalance(new Date(mm1, dd1, yyyy1), new Date(mm2, dd2, yyyy2));
    }

    public String toString() {
        String str = "";
        if (portfolio.isEmpty()) {
            return "No Data";
        }
        Stack<Transaction> temp = new Stack<>();
        while (!portfolio.isEmpty()) {
            str += portfolio.peek() + "\n";
            temp.push(portfolio.pop());
        }

        while (!temp.isEmpty())
            portfolio.push(temp.pop());

        return str;
    }
}