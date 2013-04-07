package nu.danielsundberg.gameofkrowns.application.exception;

public class CountyNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public CountyNotFoundException(String message) {
        super(message);
    }

}
