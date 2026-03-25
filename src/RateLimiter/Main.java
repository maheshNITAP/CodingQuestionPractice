package RateLimiter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        TokenBucketRateLimiter limiter= new TokenBucketRateLimiter(5,2);
//        for(int i=0;i<100;i++){
//            if(limiter.allowRequest()){
//                System.out.println("Request "+i+" allowed");
//            }else{
//                System.out.println("Request "+i+" denied");
//            }
//            Thread.sleep(300);
//        }

        UserRateLimiter userRateLimiter= new UserRateLimiter();
        userRateLimiter.allowRequest("user1");
        userRateLimiter.allowRequest("user1");
        userRateLimiter.allowRequest("user1");
        userRateLimiter.allowRequest("user1");
        userRateLimiter.allowRequest("user1");
        userRateLimiter.allowRequest("user1");
        userRateLimiter.allowRequest("user1");
        userRateLimiter.allowRequest("user1");

    }
}
