import java.util.Stack;

public class FinanceReport {
    private Stack<Transaction> portfolio;

    public FinanceReport() {
        portfolio = new Stack<>();
    }

    public void addTransaction(Transaction transaction) {
        portfolio.push(transaction);
    }

    public void addTransaction(boolean isDeposit, String category, double paid, Date date) {
        addTransaction(new Transaction(isDeposit, category, paid, date));
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

    public void partialReport(int M1, int D1, int YYY1, int M2, int D2, int YYY2) {
        partialReport(new Date(M1, D1, YYY1), new Date(M2, D2, YYY2));
    }

    public double partialBalance(Date date1, Date date2) {
        Stack<Transaction> temp = new Stack<>();
        double total = 0.0;
        while (!portfolio.isEmpty()) {
            Transaction transaction = portfolio.pop();

            if (transaction.getDate().compare(date1) && date2.compare(transaction.getDate())) {
                if (transaction.getType())
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

    public double partialBalance(int M1, int D1, int YYY1, int M2, int D2, int YYY2) {
        return partialBalance(new Date(M1, D1, YYY1), new Date(M2, D2, YYY2));
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