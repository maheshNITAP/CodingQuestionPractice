package LLD.ChainOfResponsibilityPattern;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(int level, LogProcessor nextLoggerProcessor) {
        this.level = level;
        this.nextLoggerProcessor = nextLoggerProcessor;
    }
    @Override
    protected void write(String message) {
        System.out.println("Info Log: " + message);

    }
}
