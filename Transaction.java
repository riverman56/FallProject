/*



*/
public Class Transaction{

    private boolean type;
    private String category;
    private double amount;
    private String date;

    public Transaction(){
        type = true;
        category = "";
        amount = 0.0;
        date = "NaN";
    }

    public Transaction(boolean, isDeposit, String descript, double paid, String date){
        type = isDeposit;
        category = descript;
        amount = paid;
        this.date = mmddyyyy
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

    public String getDate(){
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
        String str = "$" + amount;

        if(type){
            str += " deposited ";
        }else{
            str += " expended ";
        }
        str += "on " + date + " for " + category ".";
    }
}