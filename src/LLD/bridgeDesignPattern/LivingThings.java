package LLD.bridgeDesignPattern;

public abstract class LivingThings {
    protected BreathingProcess breathingProcess;

    public LivingThings(BreathingProcess breathingProcess) {
        this.breathingProcess = breathingProcess;
    }

    public abstract void breath();
}
