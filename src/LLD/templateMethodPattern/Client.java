package LLD.templateMethodPattern;

public class Client {
    public static void main(String[] args) {
        PaymentFlow payToFriend = new PayToFriend();
        payToFriend.sendMoney();

        System.out.println("-------------");

        PaymentFlow payToMerchant = new PayToMerchant();
        payToMerchant.sendMoney();
    }
}
