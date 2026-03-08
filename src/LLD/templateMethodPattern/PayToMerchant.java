package LLD.templateMethodPattern;

public class PayToMerchant  extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("Validating request for PayToMerchant");
    }

    @Override
    public void calculatePlatformFees() {
        System.out.println("2% fees charged for PayToMerchant");
    }

    @Override
    public void debitAmount() {
        System.out.println("Debiting amount for PayToMerchant");
    }

    @Override
    public void creditAmount() {
        System.out.println("Crediting amount for PayToMerchant");
    }
}
