package LLD.ChainOfResponsibilityPattern;

public class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(int level, LogProcessor nextLoggerProcessor) {
        this.level = level;
        this.nextLoggerProcessor = nextLoggerProcessor;
    }
    @Override
    protected void write(String message) {
        System.out.println("Debug Log: " + message);

    }
}
