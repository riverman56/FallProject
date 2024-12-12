package com.example;

/*



*/
public class Transaction {
    private boolean isDeposit;
    private String category;
    private double amount;
    private Date date;

    // contructors
    public Transaction(boolean isDeposit, String category, double amount, Date date) {
        this.isDeposit = isDeposit;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public Transaction(boolean isDeposit, String category, double amount, int mm, int dd, int yyyy) {
        this.isDeposit = isDeposit;
        this.category = category;
        this.amount = amount;
        date = new Date(mm, dd, yyyy);
    }

    // return methods
    public boolean getIsDeposit() {
        return isDeposit;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    // set methods
    public void setIsDeposit(boolean isDeposit) {
        this.isDeposit = isDeposit;
    }

    public void setCategory(String descript) {
        category = descript;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString() {
        String str = "";

        if (isDeposit)
            str += "+";
        else
            str += "-";

        return str + "$" + amount + " on " + date + " for " + category + ".";
    }
}