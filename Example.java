import java.util.*;
public class Example {

    public static void main(String args[]) {
        int in=0,amount=0,accountn=0;
        Scanner sc=new Scanner(System.in);
        
        
        Account checkingAccount =new Account(2000,500);
        Account savingsAccount=new Account(1000,3000);
        int accountType;//1-Checki ng 2-Savings
        int cardType; // 1-Credit 2-Debit

        while(true){
            System.out.println("Choose the acc type\n 1 - Checking\n 2- Savings");
            accountType=sc.nextInt();
            if(accountType<1 || accountType>2){
                System.out.println("Choose from the options");
                continue;
            }
            
                
            

            System.out.println("Choose the card type: \n 1-Credit \n2-Debit");
            cardType=sc.nextInt();
            if(cardType<1 || cardType>2){
                System.out.println("Choose from the options");
                continue;
            }
        System.out.println("Menu:\nSelect anyone of the following transaction:\n 1. Extract money\n 2.Add money \n 3. Show History\n 4-Exit");
        in=sc.nextInt();
        switch (in) {
            case 1:
                // Call extract 
                System.out.println("Enter the amount");
                amount=sc.nextInt();
                if(accountType==1){

                checkingAccount.extractMoney(amount,cardType);}
                else{
                    savingsAccount.extractMoney(amount,cardType);
                    
                }
                break;
            case 2:
                //Call add
                System.out.println("Enter the amount");
                amount=sc.nextInt();
                if(accountType==1){

                    checkingAccount.addMoney(amount,cardType);}
                    else{
                        savingsAccount.addMoney(amount,cardType);
                        
                    }
                break;
            case 3:
                //show history
                if(accountType==1){
                    checkingAccount.showHistory(cardType);
                }
                else{
                    savingsAccount.showHistory(cardType);
                }
                break;
            case 4:
                return;
                
                default:
                System.out.println("Choose from above options");
                break;
        }
        
        

    }
    }

}
class Account{
    int creditCardBalance,debitCardBalance;
    List<Integer> creditCardTransactions,debitCardTransactions;
    ArrayList <Integer> transactions;
    public Account(int cb, int db){

        creditCardBalance=cb;
        debitCardBalance=db;

        creditCardTransactions=new ArrayList<>();
        debitCardTransactions=new ArrayList<>();
    }
    public void extractMoney(int amount,int cardType){
        
        if(amount%500!=0){
            System.out.println("Please enter an amount which is multiple of 500");
            return;
        }
        if(cardType==1){
            if(creditCardBalance<amount){
                System.out.println("Not enough credit left");
                return;
            }
        
        
        creditCardBalance-=amount;
        creditCardTransactions.add(-1*amount);
        
            if(debitCardBalance<amount){
                System.out.println("Insufficient funds");
                return;
            }
            debitCardBalance-=amount;
            debitCardTransactions.add(-1*amount);
        
        System.out.println("Amount extracted sucessfully");
        }    
        
    }
    public void addMoney(int amount, int cardType){
        if(amount%500!=0){
            System.out.println("Amount should be multiple of 500");
            return;
        }
        if(cardType==1){
            
            creditCardBalance += amount;
            creditCardTransactions.add(amount);
        }
        else{
            debitCardBalance+=amount;
            debitCardTransactions.add(amount);
        }
        System.out.println("Amount added succesfully");
        
    }
    public void showHistory(int cardType){
        if(cardType==1){
            System.out.println("Credit Card transactions are:");
            System.out.println(creditCardTransactions.toString());
        }
        else{
            System.out.println("Debit Card transactions are:");
            System.out.println(creditCardTransactions.toString());
        }
    }
}

