package RateLimiter.SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class RateLimiterUsingSlidingWindow {
    private int capacity;
    Deque<Long> window;
    private Long windowSizeInMillis;

    public RateLimiterUsingSlidingWindow(int capacity, int windowSizeInSeconds){
        this.capacity=capacity;
        this.window=new LinkedList<>();
        this.windowSizeInMillis=windowSizeInSeconds*1000L;
    }

    public synchronized boolean isAllowed(){
        long curr=System.currentTimeMillis();
        while(!window.isEmpty() && curr-window.peekFirst()>=windowSizeInMillis){
            window.pollFirst();
        }
        if(window.size()<capacity){
            window.add(curr);
            return true;
        }
        return false;

    }
    public static void main(String[] args) throws InterruptedException {
        RateLimiterUsingSlidingWindow limiter= new RateLimiterUsingSlidingWindow(3,5);
        for(int i=0;i<10;i++){
            System.out.println(limiter.isAllowed());
            if(i==5)
                Thread.sleep(10000);
        }
    }

}
