package nu.danielsundberg.gameofkrowns.application.exception;

/**
 * Illegal game state exception.
 */
public class IllegalGameStateException extends Exception {

    private static final long serialVersionUID = 1L;

    public IllegalGameStateException(String message) {
        super(message);
    }

}
