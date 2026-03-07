package LLD.mementoDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationCareTaker {
    List<ConfigurationMemento> mementoList = new ArrayList<>();

    public void createMemento(ConfigurationMemento memento){
        mementoList.add(memento);
    }

    public ConfigurationMemento undo(){
        if(!mementoList.isEmpty()){
            return mementoList.remove(mementoList.size() - 1);
        }
        return null;
    }
}
