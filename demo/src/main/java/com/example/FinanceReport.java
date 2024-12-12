package com.example;

import java.util.Stack;

public class FinanceReport {
    private Stack<Transaction> portfolio;

    public FinanceReport() {
        portfolio = new Stack<>();
    }

    public void addTransaction(Transaction transaction) {
        Stack<Transaction> temp = new Stack<>();
        while (!portfolio.isEmpty() && transaction.getDate().compare(portfolio.peek().getDate())) {
            temp.push(portfolio.pop());
        }
        portfolio.push(transaction);
        while (!temp.isEmpty())
            portfolio.push(temp.pop());
    }

    public void addTransaction(boolean isDeposit, String category, double amount, Date date) {
        addTransaction(new Transaction(isDeposit, category, amount, date));
    }

    public void addRecurring(boolean isDeposit, String category, double amount, Date start, Date end,
            int billingCycleMonths) {
        Date lastPaid = start;
        while (end.compare(lastPaid)) {
            addTransaction(isDeposit, category, amount, lastPaid);
            lastPaid = new Date((lastPaid.month + billingCycleMonths) % 12, lastPaid.day,
                    lastPaid.year + (lastPaid.month + billingCycleMonths) / 12);
        }
    }

    public double fullBalance() {
        return partialBalance(00, 00, 0000, 99, 99, 9999);
    }

    public String fullReport() {
        return partialReport(00, 00, 0000, 99, 99, 9999);
    }

    public String partialReport(Date date1, Date date2) {
        String str = "";
        Stack<Transaction> temp = new Stack<>();
        while (!portfolio.isEmpty()) {
            Transaction transaction = portfolio.pop();

            if (transaction.getDate().compare(date1) && date2.compare(transaction.getDate()))
                str += transaction + "\n";

            temp.push(transaction);
        }

        while (!temp.isEmpty())
            portfolio.push(temp.pop());
        return str;
    }

    public String partialReport(int mm1, int dd1, int yyyy1, int mm2, int dd2, int yyyy2) {
        return partialReport(new Date(mm1, dd1, yyyy1), new Date(mm2, dd2, yyyy2));
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
        if (portfolio.isEmpty()) {
            return "No Data";
        }
        return fullReport();
    }
}