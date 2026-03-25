package RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;

public class TokenBucketRateLimiter {
    private final int capacity;
    private final int refillRatePerSecond;
    private AtomicInteger tokens;
    private  long lastRefillTimeStamp;

    public TokenBucketRateLimiter(int capacity, int refillRatePerSecond){
        this.capacity=capacity;
        this.refillRatePerSecond=refillRatePerSecond;
        this.tokens =  new AtomicInteger(capacity);
        lastRefillTimeStamp= System.currentTimeMillis();
    }

    public synchronized boolean allowRequest(){
        refillTokens();
        if(tokens.get()>0){
            tokens.decrementAndGet();
            return true;
        }
        return false;
    }

    private void refillTokens(){
        long now= System.currentTimeMillis();
        long elapsed =(now-lastRefillTimeStamp)/1000;
        int tokenToAdd= (int) elapsed*refillRatePerSecond;
        if(tokenToAdd>0){
            int newTokenCount=Math.min(capacity, tokenToAdd+tokens.get());
            tokens.set(newTokenCount);
            lastRefillTimeStamp= now;
        }
    }
}
