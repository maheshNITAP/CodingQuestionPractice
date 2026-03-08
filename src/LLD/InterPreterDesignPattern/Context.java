package LLD.InterPreterDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class Context {
    Map<String,Integer> contextMap = new HashMap<>();

        public void setValue(String key, Integer value){
            contextMap.put(key, value);
        }

        public Integer getValue(String key){
            return contextMap.get(key);
        }
}
