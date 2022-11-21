package Task2;

public class WrongOfDataInputException extends Exception {
    private final static String MASSAGE = "incorrect date of input";

    public WrongOfDataInputException(String massage) {
        super(massage);
    }
}


