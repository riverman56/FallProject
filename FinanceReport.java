

public Class FinanceReport{

    private Stack<Transaction> portfolio;

    public FinanceReport(){

        portfolio = new Stack<>();
    }

    public void addTransaction(Transaction transaction){
        portfolio.push(transaction);
    }
    public void addTransaction(boolean, isDeposit, String descript, double paid, String date){
        portfolio.push(new Transaction(isDeposit, descript, paid, date));
    }

    public double fullBalance(){
        Stack<Transaction> temp = new Stack<>();
        double total = 0.0;
        while(!portfolio.isEmpty()){
            if(type){
                total += portfolio.peek().getAmount();
            }else{
                total -= portfolio.peek().getAmount();
            }
            temp.push(portfolio.pop());
        }
        while(!temp.isEmpty()){
            portfolio.push(temp.pop());
        }
        return total;
    }

    public void fullReport(){
        Stack<Transaction> temp = new Stack<>();
        while(!portfolio.isEmpty()){
            System.out.println(portfolio.peek())
            temp.push(portfolio.pop());
        }
        while(!temp.isEmpty()){
            portfolio.push(temp.pop());
        }
    }

    public double partialBalance(Date date1, Date date2){
        Stack<Transaction> temp = new Stack<>();
        double total = 0.0;
        while(!portfolio.isEmpty()){
            if(portfolio.peek().getDate().compareDates(date1) && date2.compareDates(portfolio.peek().getDate())){}
                if(portfolio.getType()){
                    total += portfolio.peek().getAmount();
                }else{
                    total -= portfolio.peek().getAmount();
                }
            }
            temp.push(portfolio.pop());
        }
        while(!temp.isEmpty()){
            portfolio.push(temp.pop());
        }
        return total;
    }

    public double partialBalance(int M1, int D1, int YYY1, int M2, int D2, int YYY2){
        return partialBalance(new Date(M1,D1,YYY1), new Date(M2,D2,YYY2));
    }

}