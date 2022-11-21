package Task1;

public class WrongLoginException extends IndexOutOfBoundsException {
    private final static String MASSAGE = "incorrect length of login";

    public WrongLoginException() {
        super(MASSAGE);
    }
}
