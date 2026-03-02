package LLD.CommandDesignPattern;

import java.util.Stack;

public class RemoteController {
    ICommand command;
    Stack<ICommand> commandHistory= new Stack<>();

    RemoteController(){}

    public void setCommand(ICommand iCommand) {
        this.command = iCommand;
    }

    public void pressButton() {
        command.execute();
        commandHistory.push(command);
    }

    public void pressUndo() {
        if (!commandHistory.isEmpty()) {
            ICommand lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("No commands to undo.");
        }
    }
}
