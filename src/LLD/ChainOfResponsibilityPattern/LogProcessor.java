package LLD.ChainOfResponsibilityPattern;

public  abstract class LogProcessor {
    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int ERROR = 3;
    public static final int FATAL = 4;

    int level;
    LogProcessor nextLoggerProcessor;

    public void logMessage(int level, String message){
        if(this.level == level)
            write(message);

        //Pass to next handler in chain if exist
        if(this.nextLoggerProcessor != null){
            this.nextLoggerProcessor.logMessage(level, message);
        }
    }



    abstract protected void write(String message);

}
