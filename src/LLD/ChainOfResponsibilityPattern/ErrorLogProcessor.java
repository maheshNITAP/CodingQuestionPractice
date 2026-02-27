package LLD.ChainOfResponsibilityPattern;

public class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(int level, LogProcessor nextLoggerProcessor) {
        this.level = level;
        this.nextLoggerProcessor = nextLoggerProcessor;
    }
    @Override
    protected void write(String message) {
        System.out.println("Error Log: " + message);

    }
}
