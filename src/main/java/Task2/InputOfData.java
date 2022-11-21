package Task2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class InputOfData {

    private ArrayList<String> dataPerson;

    public InputOfData() {
        this.dataPerson = dataPerson;
    }

    public ArrayList<String> getDataPerson() {
        return dataPerson;
    }

    // ÏÂÚÓ‰ ‚‚Ó‰‡ ‰‡ÌÌ˚ı
    public ArrayList<String> input() throws WrongOfDataInputException {
        Scanner in = new Scanner(System.in);

        System.out.print("\nenter the person's data separated by a space in the following order:\n");
        System.out.print("name patronymic surname gender(W or M)  birthdate(format: dd.mm.yy) phoneNumber(format: 8XXXXXXXXXX): \n");
        ArrayList<String> dataPerson = new ArrayList<>(Arrays.asList(in.nextLine().split(" ")));

        System.out.println(dataPerson.toString());

        cheÒkValidityOfInputData(dataPerson);
        return dataPerson;
    }

    public static void cheÒkValidityOfInputData(ArrayList<String> dataPerson) throws WrongOfDataInputException {
        if (dataPerson.contains(" ")) {
            throw new WrongOfDataInputException("input error: presence of extra spaces");
        }
        if (dataPerson.size() < 6) {
            throw new WrongOfDataInputException("input error: missed input data");
        }
        if (dataPerson.size() > 6) {
            throw new WrongOfDataInputException(" input error: extra input data");
        }

        if (!dataPerson.get(0).matches("[a-zA-Z‡-ˇ¿-ﬂ]+") || !dataPerson.get(1).matches("[a-zA-Z‡-ˇ¿-ﬂ]+") || !dataPerson.get(2).matches("[a-zA-Z‡-ˇ¿-ﬂ]+")) {  //[a-zA-Z‡-ˇ¿-ﬂ]+   \\p{L}
            throw new WrongOfDataInputException("  syntax error when entering full name");
        }
        if (!Objects.equals(dataPerson.get(3), Gender.W.name()) && !Objects.equals(dataPerson.get(3), Gender.M.name())) {
            throw new WrongOfDataInputException(" error type of gender");
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            LocalDate localDate = LocalDate.parse(dataPerson.get(4), formatter);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        if (!dataPerson.get(5).matches("\\d{11}") || dataPerson.get(5).charAt(0) != '8') {
            throw new WrongOfDataInputException(" incorrect of format of phone number");
        }
    }
}
