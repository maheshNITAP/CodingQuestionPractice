package LLD.CommandDesignPattern;

public class Client {
    public static void main(String[] args) {
        AirCondition ac = new AirCondition();

        RemoteController remoteObj = new RemoteController();

        remoteObj.setCommand(new TurnOnCommand(ac));
        remoteObj.pressButton();

        remoteObj.setCommand(new TurnOffCommand(ac));
        remoteObj.pressButton();

        remoteObj.pressUndo();
        remoteObj.pressUndo();


    }
}
