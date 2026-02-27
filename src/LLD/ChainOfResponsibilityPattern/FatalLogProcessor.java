package LLD.ChainOfResponsibilityPattern;

public class FatalLogProcessor extends LogProcessor {
    public FatalLogProcessor(int level, LogProcessor nextLoggerProcessor) {
        this.level = level;
        this.nextLoggerProcessor = nextLoggerProcessor;
    }
    @Override
    protected void write(String message) {
        System.out.println("Fatal Log: " + message);

    }
}
