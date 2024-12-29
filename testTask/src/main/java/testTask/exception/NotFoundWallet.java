package testTask.exception;

public class NotFoundWallet extends RuntimeException{

    public NotFoundWallet(String message) {
        super(message);
    }
}
