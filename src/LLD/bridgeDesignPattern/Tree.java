package LLD.bridgeDesignPattern;

public class Tree extends LivingThings {
    public Tree(BreathingProcess breathingProcess) {
        super(breathingProcess);
    }

    @Override
    public void breath() {
        System.out.print("Tree is ");
        breathingProcess.breath();
    }
}
