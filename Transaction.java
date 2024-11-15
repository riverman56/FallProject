/*



*/
public class Transaction
{
    private boolean type;
    private String category;
    private double amount;
    private Date date;

    //contructors
    public Transaction()
    {
        type = true;
        category = "";
        amount = 0.0;
        date = null;
    }
    
    public Transaction(boolean isDeposit, String category, double paid, Date date)
    {
        type = isDeposit;
        this.category = category;
        amount = paid;
        this.date = date;
    }

    public Transaction(boolean isDeposit, String category, double paid, int MM, int DD, int YYYY)
    {
        type = isDeposit;
        this.category = category;
        amount = paid;
        date = new Date(MM, DD, YYYY);
    }

    //return methods
    public boolean getType()
    {
         return type;
    }

    public String getCategory()
    {
        return category;
    }

    public double getAmount()
    {
        return amount;
    }

    public Date getDate()
    {
        return date;
    }

    //edit methods
    public void editType(boolean isDeposit)
    {
        type = isDeposit;
    }

    public void editCategory(String descript)
    {
        category = descript;
    }

    public void editAmount(double paid)
    {
        amount = paid;
    }

    public void editDate(Date date)
    {
        this.date = date;
    }

    public String toString()
    {
        String str = "";

        if (type)
            str += "+";
        else
            str += "-";
        
        return str + "$" + amount + " on " + date + " for " + category + "." ;
    }
}