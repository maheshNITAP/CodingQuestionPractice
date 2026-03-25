package RateLimiter;

import java.util.concurrent.ConcurrentHashMap;

public class UserRateLimiter {
    ConcurrentHashMap<String, TokenBucketRateLimiter> userLimiter = new ConcurrentHashMap<>();

    public boolean allowRequest(String  userName){
        TokenBucketRateLimiter limiter = userLimiter.computeIfAbsent(userName, k-> new TokenBucketRateLimiter(5,2));
        return limiter.allowRequest();
    }
}
