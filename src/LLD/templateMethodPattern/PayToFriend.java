package LLD.templateMethodPattern;

public class PayToFriend  extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("Validating request for PayToFriend");
    }

    @Override
    public void calculatePlatformFees() {
        System.out.println("0% fees charged for PayToFriend");
    }

    @Override
    public void debitAmount() {
        System.out.println("Debiting amount for PayToFriend");
    }

    @Override
    public void creditAmount() {
        System.out.println("Crediting amount for PayToFriend");
    }
}
