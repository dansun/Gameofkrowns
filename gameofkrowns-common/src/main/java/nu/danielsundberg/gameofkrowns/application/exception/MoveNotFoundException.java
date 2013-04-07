package nu.danielsundberg.gameofkrowns.application.exception;

public class MoveNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public MoveNotFoundException(String message) {
        super(message);
    }

}
