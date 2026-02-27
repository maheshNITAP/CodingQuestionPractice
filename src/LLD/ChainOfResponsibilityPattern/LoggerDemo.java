package LLD.ChainOfResponsibilityPattern;

public class LoggerDemo {
    public static void main(String[] args) {
        LogProcessor fatalLogger = new FatalLogProcessor(LogProcessor.FATAL,null);
        LogProcessor errorLogger = new ErrorLogProcessor(LogProcessor.ERROR,fatalLogger);
        LogProcessor infoLogger = new InfoLogProcessor(LogProcessor.INFO,errorLogger);
        LogProcessor debugLogger = new DebugLogProcessor(LogProcessor.DEBUG,infoLogger);

        debugLogger.logMessage(LogProcessor.DEBUG, "This is a debug message");
            debugLogger.logMessage(LogProcessor.INFO, "This is an info message");
            debugLogger.logMessage(LogProcessor.ERROR, "This is an error message");
            debugLogger.logMessage(LogProcessor.FATAL, "This is a fatal message");
    }
}
