/*



*/
public Class Transaction{

    private boolean type;
    private String category;
    private double amount;
    private Date date;

    public Transaction(){
        type = true;
        category = "";
        amount = 0.0;
        date = null;
    }

    public Transaction(boolean, isDeposit, String descript, double paid, Date date){
        type = isDeposit;
        category = descript;
        amount = paid;
        this.date = date;
    }

    public Transaction(boolean, isDeposit, String descript, double paid, int MM, int DD, int YYYY){
        type = isDeposit;
        category = descript;
        amount = paid;
        date = new Date(MM, DD, YYYY);
    }

    //return methods
    public String getType(){
         return type;
    }

    public String getCategory(){
        return category;
    }

    public double getAmount(){
        return amount;
    }

    public Date getDate(){
        return date;
    }

    //edit methods
    public void editType(boolean isDeposit){
        type = isDeposit;
    }

    public void editCategory(String descript){
        category = descript;
    }

    public void editAmount(double paid){
        amount = paid;
    }

    public void editDate(String date){
        this.date = date;
    }

    public String toString(){
        String str = "";

        if(type){
            str += "+";
        }else{
            str += "-";
        }
        str += "$" + amount + "on " + date + " for " + category ".";
    }
}