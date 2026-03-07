package LLD.mementoDesignPattern;

public class Client {
    public static void main(String[] args) {
        ConfigurationCareTaker careTakerObj= new ConfigurationCareTaker();
        ConfigurationOriginator originatorObj = new ConfigurationOriginator(5, 10);

        ConfigurationMemento snapshot1 = originatorObj.createMemento();
        careTakerObj.createMemento(snapshot1);

        originatorObj.setHeight(7);
        originatorObj.setWidth(12);

        ConfigurationMemento snapshot2 = originatorObj.createMemento();
        careTakerObj.createMemento(snapshot2);

        originatorObj.setHeight(9);
        originatorObj.setWidth(15);

        //UNDO
        ConfigurationMemento mementoToBeRestored = careTakerObj.undo();
        originatorObj.restoreFromMemento(mementoToBeRestored);
        System.out.println("After first undo: Height: " + originatorObj.height + " Width: " + originatorObj.width);
    }
}
