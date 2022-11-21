package Task1;

import java.util.Scanner;

public class ValidLoginPassword {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Input login");
        String login = in.nextLine();
        System.out.println("Input password");
        String password = in.nextLine();
        System.out.println("Repeat password");
        String confirmPassword = in.nextLine();

        System.out.println(validLogin(login, password, confirmPassword));

    }

    static boolean validLogin(String login, String password, String confirmPassword) throws Exception {


        if (!login.matches("^[a-zA-Z0-9_]+$")) {
            throw new Exception("Incorrect login");
        } else if (login.length() >= 20) {
            throw new WrongLoginException();
        } else if (!password.matches("^[a-zA-Z0-9_]+${1,20}")) {
            throw new WrongPasswordException();
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password has not matched");
        } else {
            return true;
        }


    }
}