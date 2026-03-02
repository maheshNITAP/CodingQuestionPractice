package LLD.CommandDesignPattern;

public class TurnOnCommand implements ICommand {
    private AirCondition ac;
    private boolean previousState;

    public TurnOnCommand(AirCondition ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        previousState = ac.isOn();
        ac.turnOn();
    }

    @Override
    public void undo() {
        System.out.print("Undo: Turn On command. ");
        if (!previousState) {
            ac.turnOff();
        }

    }
}
