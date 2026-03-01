package LLD.bridgeDesignPattern;

public class Fish extends LivingThings {
    public Fish(BreathingProcess breathingProcess) {
        super(breathingProcess);
    }

    @Override
    public void breath() {
        System.out.print("Fish is ");
        breathingProcess.breath();
    }
}
