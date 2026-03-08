package LLD.templateMethodPattern;

public  abstract class PaymentFlow {
    public abstract void validateRequest();
    public abstract void calculatePlatformFees();
    public abstract  void debitAmount();
    public abstract void creditAmount();
    //Template Method: this is template method which defines the order of steps to execute the task
    public final void sendMoney(){
        validateRequest();
        calculatePlatformFees();
        debitAmount();
        creditAmount();
    }
}
