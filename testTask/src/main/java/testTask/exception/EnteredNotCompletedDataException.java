package testTask.exception;

public class EnteredNotCompletedDataException extends RuntimeException{
    public EnteredNotCompletedDataException(String message) {
        super(message);
    }
}
