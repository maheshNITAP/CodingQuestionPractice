package LLD.CommandDesignPattern;

public class TurnOffCommand implements ICommand {
    private AirCondition ac;
    private boolean previousState;

    public TurnOffCommand(AirCondition ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        previousState = ac.isOn();
        ac.turnOff();
    }

    @Override
    public void undo() {
        System.out.print("Undo: Turn Off command. ");
        if (previousState) {
            ac.turnOn();
        }
    }
}
