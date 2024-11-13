

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

    public double total(){
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

}