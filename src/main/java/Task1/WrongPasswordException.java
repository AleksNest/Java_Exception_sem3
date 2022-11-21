package Task1;

public class WrongPasswordException extends Exception {
    private final static String MASSAGE = "incorrect password";

    public WrongPasswordException() {
        super(MASSAGE);
    }

    public WrongPasswordException(String massage) {
        super(massage);
    }
}